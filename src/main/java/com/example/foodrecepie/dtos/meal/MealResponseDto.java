package com.example.foodrecepie.dtos.meal;

import java.util.List;

import lombok.Data;

@Data
public class MealResponseDto {
    private List<MealDto> meals;
}
