package com.example.foodrecepie.services.list;

import java.util.Map;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.foodrecepie.apiclient.ListApiClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListService {
    private final ListApiClient listApiClient;

    public <T> T getListResult(String key, String word, @NonNull Class<T> responseType) {
        return listApiClient.getListResult(Map.of(key, word), responseType);
    }
}
