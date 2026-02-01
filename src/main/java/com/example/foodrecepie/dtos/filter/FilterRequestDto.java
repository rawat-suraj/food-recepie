package com.example.foodrecepie.dtos.filter;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FilterRequestDto {
    private String key;
    private String word;
}
