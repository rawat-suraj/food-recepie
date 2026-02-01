package com.example.foodrecepie.dtos.list;

import lombok.Data;

@Data
public class ListIngredientsDto {
    private String idIngredient;
    private String strIngredient;
    private String strDescription;
    private String strThumb;
    private String strType;
}
