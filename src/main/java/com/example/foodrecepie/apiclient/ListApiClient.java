package com.example.foodrecepie.apiclient;

import java.util.Map;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ListApiClient {
    private final ApiClient baseClient;

    public <T> T getListResult(Map<String, ?> param, @NonNull Class<T> responseType) {
        return baseClient.get("/list.php", param, responseType);
    }
}
