package com.lexlopee.sportfood.dto.comida;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MealDTO {
    @JsonProperty("idMeal")
    private String idMeal;

    @JsonProperty("strMeal")
    private String nombre;

    @JsonProperty("strMealThumb")
    private String imagen;

}
