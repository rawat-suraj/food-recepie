package com.example.foodrecepie.apiclient;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.foodrecepie.dtos.meal.MealResponseDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SearchApiClient {
    private final ApiClient baseApiClient;

    public MealResponseDto getSearchResult(Map<String, ?> search) {
        return baseApiClient.get("/search.php", search, MealResponseDto.class);
    }
}
