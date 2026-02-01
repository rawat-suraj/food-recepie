package com.example.foodrecepie.apiclient;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.foodrecepie.dtos.filter.FilterResponseDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FilterApiClient {
    private final ApiClient baseApiClient;

    public FilterResponseDto getFilterResult(Map<String, ?> param) {
        return baseApiClient.get("/filter.php", param, FilterResponseDto.class);
    }
}
