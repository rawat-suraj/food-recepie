package com.example.foodrecepie.services.search;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.foodrecepie.apiclient.SearchApiClient;
import com.example.foodrecepie.dtos.meal.MealResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchApiClient searchApiClient;

    public MealResponseDto getSearch(String key, String word) {
        if (key == null || word == null) {
            throw new RuntimeException("Invalid value provided for search");
        }
        return searchApiClient.getSearchResult(Map.of(key, word));
    }
}
