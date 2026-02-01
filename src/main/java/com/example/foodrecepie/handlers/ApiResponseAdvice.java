package com.example.foodrecepie.handlers;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ApiResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(
            @Nullable MethodParameter returnType,
            @Nullable Class<? extends HttpMessageConverter<?>> converterType) {

        // Don't wrap already wrapped responses
        if (returnType == null) {
            return false;
        }
        Class<?> type = returnType.getParameterType();
        return !ApiResponse.class.isAssignableFrom(type) && !byte[].class.isAssignableFrom(type);
    }

    @Override
    public Object beforeBodyWrite(
            @Nullable Object body,
            @Nullable MethodParameter returnType,
            @Nullable MediaType selectedContentType,
            @Nullable Class<? extends HttpMessageConverter<?>> selectedConverterType,
            @Nullable ServerHttpRequest request,
            @Nullable ServerHttpResponse response) {

        // Skip null bodies
        if (body == null)
            return new ApiResponse<>(true, "Success", null);

        // If body is already ApiResponse, return as-is
        if (body instanceof ApiResponse)
            return body;

        // If body is raw bytes (Swagger, files, images), skip wrapping
        if (body instanceof byte[])
            return body;

        if (request != null && (request.getURI().getPath().startsWith("/swagger")
                || request.getURI().getPath().startsWith("/v3/api-docs"))) {
            return body;
        }

        // Only wrap JSON responses
        if (selectedContentType != null && selectedContentType.includes(MediaType.APPLICATION_JSON)) {
            return new ApiResponse<>(true, "Success", body);
        }

        // Otherwise return body as-is (text/html, etc.)
        return body;
    }
}
