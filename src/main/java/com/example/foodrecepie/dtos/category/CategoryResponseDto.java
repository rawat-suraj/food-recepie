package com.example.foodrecepie.dtos.category;

import java.util.List;

import lombok.Data;

@Data
public class CategoryResponseDto {
    private List<CategoryDto> categories;
}
