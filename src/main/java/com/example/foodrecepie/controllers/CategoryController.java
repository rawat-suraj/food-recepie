package com.example.foodrecepie.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodrecepie.dtos.category.CategoryResponseDto;
import com.example.foodrecepie.services.category.CategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("")
    public CategoryResponseDto getCategories() {
        return categoryService.getCategories();
    }

}
