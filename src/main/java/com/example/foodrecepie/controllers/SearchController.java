package com.example.foodrecepie.controllers;

import com.example.foodrecepie.dtos.search.SearchRequestDto;
import com.example.foodrecepie.dtos.meal.MealResponseDto;
import com.example.foodrecepie.services.search.SearchService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping("")
    public MealResponseDto getSearchResult(@RequestParam SearchRequestDto search) {
        return searchService.getSearch(search.getKey(), search.getWord());
    }
}
