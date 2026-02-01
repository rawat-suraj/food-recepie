package com.example.foodrecepie.config;

import com.example.foodrecepie.handlers.ApiResponse;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Component
public class ApiResponseWrappingFilter implements WebFilter {

    private static final List<String> swaggerPaths = List.of("/swagger", "/v3/api-docs", "/webjars", "/swagger-ui");
    private static final Map<Class<?>, Boolean> wrappedTypes = new ConcurrentHashMap<>();
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    @NonNull
    public Mono<Void> filter(@NonNull ServerWebExchange exchange, @NonNull WebFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();

        // Skip Swagger paths
        if (swaggerPaths.stream().anyMatch(path::startsWith)) {
            return chain.filter(exchange);
        }

        ServerHttpResponse originalResponse = exchange.getResponse();
        DataBufferFactory bufferFactory = originalResponse.bufferFactory();

        ServerHttpResponse decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
            @Override
            @SuppressWarnings("unchecked")
            public Mono<Void> writeWith(org.reactivestreams.Publisher<? extends DataBuffer> body) {
                MediaType contentType = getDelegate().getHeaders().getContentType();
                HttpStatusCode statusCode = getDelegate().getStatusCode();

                // Only wrap successful JSON responses
                if (contentType != null && contentType.includes(MediaType.APPLICATION_JSON)
                        && statusCode != null && statusCode.is2xxSuccessful()) {

                    // Use block() to get the body content synchronously
                    byte[] bytes = Flux.from(body)
                            .map(dataBuffer -> {
                                int readableByteCount = dataBuffer.readableByteCount();
                                byte[] result = new byte[readableByteCount];
                                dataBuffer.read(result);
                                DataBufferUtils.release(dataBuffer);
                                return result;
                            })
                            .reduce((a, b) -> {
                                byte[] combined = new byte[a.length + b.length];
                                System.arraycopy(a, 0, combined, 0, a.length);
                                System.arraycopy(b, 0, combined, a.length, b.length);
                                return combined;
                            })
                            .block();

                    if (bytes == null || bytes.length == 0) {
                        return super.writeWith(body);
                    }

                    String bodyStr = new String(bytes, StandardCharsets.UTF_8);
                    try {
                        // Parse and wrap the body
                        Object originalBody = objectMapper.readValue(bodyStr, Object.class);
                        ApiResponse<Object> wrapped = new ApiResponse<>(true, "Success", originalBody);
                        String wrappedJson = objectMapper.writeValueAsString(wrapped);
                        return super.writeWith(
                                Mono.just(bufferFactory.wrap(wrappedJson.getBytes(StandardCharsets.UTF_8))));
                    } catch (JsonProcessingException e) {
                        // If parsing fails, return original body
                        return super.writeWith(Mono.just(bufferFactory.wrap(bytes)));
                    }
                }

                return super.writeWith(body);
            }
        };

        return chain.filter(exchange.mutate().response(decoratedResponse).build());
    }
}
