package com.example.foodrecepie.apiclient;

import java.util.Map;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ApiClient {
    private final WebClient webClient;

    public <T> T get(@NonNull String uri, @NonNull Class<T> responseType) {
        return webClient.get().uri(uri).retrieve().bodyToMono(responseType).block();
    }

    public <T> T get(@NonNull String path, Map<String, ?> queryParams, @NonNull Class<T> responseType) {
        String uri = UriComponentsBuilder.fromPath(path).queryParams(toMultiValueMap(queryParams)).toUriString();

        return get(uri, responseType);
    }

    private MultiValueMap<String, String> toMultiValueMap(Map<String, ?> params) {
        var map = new org.springframework.util.LinkedMultiValueMap<String, String>();
        params.forEach((key, value) -> {
            if (key != null && value != null) {
                map.add(key, value.toString());
            }
        });
        return map;
    }
}
