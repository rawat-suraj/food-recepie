package com.example.foodrecepie.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${app.api.base-url}")
    private String baseUrl;

    @Bean
    WebClient webClient() {
        String url = baseUrl; // assign to local variable
        if (url == null || url.isBlank()) {
            throw new RuntimeException("app.api.base-url is not configured!");
        }
        return WebClient.builder().baseUrl(url).build();
    }
}
