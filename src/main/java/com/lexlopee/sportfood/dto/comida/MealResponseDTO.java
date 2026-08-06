package com.lexlopee.sportfood.dto.comida;

import lombok.Data;

import java.util.List;

@Data
public class MealResponseDTO {
    private List<MealDTO> meals;
}
