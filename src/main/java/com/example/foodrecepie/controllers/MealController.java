package com.example.foodrecepie.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodrecepie.dtos.meal.MealRequestDto;
import com.example.foodrecepie.dtos.meal.MealResponseDto;
import com.example.foodrecepie.services.meal.MealService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/lookup")
@RequiredArgsConstructor
public class MealController {
    private final MealService mealService;

    @GetMapping("")
    public MealResponseDto getMealById(@RequestParam MealRequestDto param) {
        return mealService.getMealDetail(param.getId());
    }

    @GetMapping("/random")
    public MealResponseDto getRandomMeal() {
        return mealService.getRandomMeal();
    }

}
