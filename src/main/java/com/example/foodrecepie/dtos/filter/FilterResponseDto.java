package com.example.foodrecepie.dtos.filter;

import java.util.List;

import lombok.Data;

@Data
public class FilterResponseDto {
    private List<FilterDto> meals;
}
