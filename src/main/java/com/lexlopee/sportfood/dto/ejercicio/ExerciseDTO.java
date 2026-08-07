package com.lexlopee.sportfood.dto.ejercicio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExerciseDTO {
    @JsonProperty ("exerciseId")
    private String exerciseId;

    @JsonProperty ("name")
    private String nombre;

    @JsonProperty ("gifUrl")
    private String gifUrl;
}
