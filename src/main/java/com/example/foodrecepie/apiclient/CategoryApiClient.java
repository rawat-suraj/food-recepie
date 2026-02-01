package com.example.foodrecepie.apiclient;

import org.springframework.stereotype.Component;

import com.example.foodrecepie.dtos.category.CategoryResponseDto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CategoryApiClient {
    private final ApiClient baseClient;

    public CategoryResponseDto getCategories() {
        return baseClient.get("/categories.php", CategoryResponseDto.class);
    }
}
