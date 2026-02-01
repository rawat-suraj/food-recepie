package com.example.foodrecepie.services.meal;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.foodrecepie.apiclient.MealApiClient;
import com.example.foodrecepie.dtos.meal.MealResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MealService {
    private final MealApiClient mealApiClient;

    public MealResponseDto getMealDetail(int mealId) {
        return mealApiClient.getMeal(Map.of("i", mealId));
    }

    public MealResponseDto getRandomMeal() {
        return mealApiClient.getRandomMeal();
    }
}
