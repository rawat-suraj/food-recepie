package com.example.foodrecepie.apiclient;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.foodrecepie.dtos.meal.MealResponseDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MealApiClient {
    private final ApiClient baseClient;

    public MealResponseDto getMeal(Map<String, ?> param) {
        return baseClient.get("/lookup.php", param, MealResponseDto.class);
    }

    public MealResponseDto getRandomMeal() {
        return baseClient.get("/random.php", MealResponseDto.class);
    }
}
