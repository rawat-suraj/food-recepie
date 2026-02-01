package com.example.foodrecepie.services.filter;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.foodrecepie.apiclient.FilterApiClient;
import com.example.foodrecepie.dtos.filter.FilterResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilterService {
    private final FilterApiClient filterApiClient;

    public FilterResponseDto getFilterResult(String key, String word) {
        return filterApiClient.getFilterResult(Map.of(key, word));
    }
}
