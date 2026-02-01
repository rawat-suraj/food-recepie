package com.example.foodrecepie.dtos.meal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealDto {

    @JsonProperty("idMeal")
    private String idMeal;

    @JsonProperty("strMeal")
    private String strMeal;

    @JsonProperty("strMealAlternate")
    private String strMealAlternate;

    @JsonProperty("strCategory")
    private String strCategory;

    @JsonProperty("strArea")
    private String strArea;

    @JsonProperty("strInstructions")
    private String strInstructions;

    @JsonProperty("strMealThumb")
    private String strMealThumb;

    @JsonProperty("strTags")
    private String strTags;

    @JsonProperty("strYoutube")
    private String strYoutube;

    @JsonProperty("strSource")
    private String strSource;

    @JsonProperty("strImageSource")
    private String strImageSource;

    @JsonProperty("strCreativeCommonsConfirmed")
    private String strCreativeCommonsConfirmed;

    @JsonProperty("dateModified")
    private String dateModified;

    // Ingredients (1..20)
    @JsonProperty("strIngredient1")
    private String strIngredient1;
    @JsonProperty("strIngredient2")
    private String strIngredient2;
    @JsonProperty("strIngredient3")
    private String strIngredient3;
    @JsonProperty("strIngredient4")
    private String strIngredient4;
    @JsonProperty("strIngredient5")
    private String strIngredient5;
    @JsonProperty("strIngredient6")
    private String strIngredient6;
    @JsonProperty("strIngredient7")
    private String strIngredient7;
    @JsonProperty("strIngredient8")
    private String strIngredient8;
    @JsonProperty("strIngredient9")
    private String strIngredient9;
    @JsonProperty("strIngredient10")
    private String strIngredient10;
    @JsonProperty("strIngredient11")
    private String strIngredient11;
    @JsonProperty("strIngredient12")
    private String strIngredient12;
    @JsonProperty("strIngredient13")
    private String strIngredient13;
    @JsonProperty("strIngredient14")
    private String strIngredient14;
    @JsonProperty("strIngredient15")
    private String strIngredient15;
    @JsonProperty("strIngredient16")
    private String strIngredient16;
    @JsonProperty("strIngredient17")
    private String strIngredient17;
    @JsonProperty("strIngredient18")
    private String strIngredient18;
    @JsonProperty("strIngredient19")
    private String strIngredient19;
    @JsonProperty("strIngredient20")
    private String strIngredient20;

    // Measures (1..20)
    @JsonProperty("strMeasure1")
    private String strMeasure1;
    @JsonProperty("strMeasure2")
    private String strMeasure2;
    @JsonProperty("strMeasure3")
    private String strMeasure3;
    @JsonProperty("strMeasure4")
    private String strMeasure4;
    @JsonProperty("strMeasure5")
    private String strMeasure5;
    @JsonProperty("strMeasure6")
    private String strMeasure6;
    @JsonProperty("strMeasure7")
    private String strMeasure7;
    @JsonProperty("strMeasure8")
    private String strMeasure8;
    @JsonProperty("strMeasure9")
    private String strMeasure9;
    @JsonProperty("strMeasure10")
    private String strMeasure10;
    @JsonProperty("strMeasure11")
    private String strMeasure11;
    @JsonProperty("strMeasure12")
    private String strMeasure12;
    @JsonProperty("strMeasure13")
    private String strMeasure13;
    @JsonProperty("strMeasure14")
    private String strMeasure14;
    @JsonProperty("strMeasure15")
    private String strMeasure15;
    @JsonProperty("strMeasure16")
    private String strMeasure16;
    @JsonProperty("strMeasure17")
    private String strMeasure17;
    @JsonProperty("strMeasure18")
    private String strMeasure18;
    @JsonProperty("strMeasure19")
    private String strMeasure19;
    @JsonProperty("strMeasure20")
    private String strMeasure20;

    /**
     * Returns a list of non-empty ingredients in order.
     */
    public List<String> getIngredients() {
        return Arrays.asList(
                strIngredient1, strIngredient2, strIngredient3, strIngredient4, strIngredient5,
                strIngredient6, strIngredient7, strIngredient8, strIngredient9, strIngredient10,
                strIngredient11, strIngredient12, strIngredient13, strIngredient14, strIngredient15,
                strIngredient16, strIngredient17, strIngredient18, strIngredient19, strIngredient20).stream()
                .filter(Objects::nonNull).map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toList());
    }

    /**
     * Returns a list of non-empty measures in order.
     */
    public List<String> getMeasures() {
        return Arrays.asList(
                strMeasure1, strMeasure2, strMeasure3, strMeasure4, strMeasure5,
                strMeasure6, strMeasure7, strMeasure8, strMeasure9, strMeasure10,
                strMeasure11, strMeasure12, strMeasure13, strMeasure14, strMeasure15,
                strMeasure16, strMeasure17, strMeasure18, strMeasure19, strMeasure20).stream().filter(Objects::nonNull)
                .map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toList());
    }
}
