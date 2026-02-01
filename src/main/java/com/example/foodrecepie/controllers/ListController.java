package com.example.foodrecepie.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodrecepie.dtos.list.ListAreaResponseDto;
import com.example.foodrecepie.dtos.list.ListCategoryResponse;
import com.example.foodrecepie.dtos.list.ListIngredientsResponseDto;
import com.example.foodrecepie.dtos.list.ListRequestDto;
import com.example.foodrecepie.services.list.ListService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/list")
@RequiredArgsConstructor
public class ListController {
    private final ListService listService;

    @GetMapping("/c")
    public ListCategoryResponse getCategoryList(@RequestParam ListRequestDto param) {
        return listService.getListResult("c", param.getWord(), ListCategoryResponse.class);
    }

    @GetMapping("/i")
    public ListIngredientsResponseDto getIngredientList(@RequestParam ListRequestDto param) {
        return listService.getListResult("i", param.getWord(), ListIngredientsResponseDto.class);
    }

    @GetMapping("/a")
    public ListAreaResponseDto getAreaList(@RequestParam ListRequestDto param) {
        return listService.getListResult("a", param.getWord(), ListAreaResponseDto.class);
    }

}
