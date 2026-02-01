package com.example.foodrecepie.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodrecepie.dtos.filter.FilterRequestDto;
import com.example.foodrecepie.dtos.filter.FilterResponseDto;
import com.example.foodrecepie.services.filter.FilterService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/filter")
@RequiredArgsConstructor
public class FilterController {
    private final FilterService filterService;

    @GetMapping("")
    public FilterResponseDto getFilterData(@RequestParam FilterRequestDto param) {
        return filterService.getFilterResult(param.getKey(), param.getWord());
    }

}
