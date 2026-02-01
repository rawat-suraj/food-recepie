package com.example.foodrecepie.dtos.list;

import java.util.List;

import lombok.Data;

@Data
public class ListAreaResponseDto {
    private List<ListAreaDto> meals;
}
