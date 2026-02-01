package com.example.foodrecepie.services.category;

import org.springframework.stereotype.Service;

import com.example.foodrecepie.apiclient.CategoryApiClient;
import com.example.foodrecepie.dtos.category.CategoryResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryApiClient categoryApiClient;

    public CategoryResponseDto getCategories() {
        return categoryApiClient.getCategories();
    }
}
