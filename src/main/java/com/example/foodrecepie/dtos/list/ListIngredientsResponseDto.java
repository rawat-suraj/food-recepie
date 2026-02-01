package com.example.foodrecepie.dtos.list;

import java.util.List;

import lombok.Data;

@Data
public class ListIngredientsResponseDto {
    private List<ListIngredientsDto> meals;
}
