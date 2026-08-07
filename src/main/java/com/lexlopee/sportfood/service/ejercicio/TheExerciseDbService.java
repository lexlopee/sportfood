package com.lexlopee.sportfood.service.ejercicio;

import com.lexlopee.sportfood.dto.ejercicio.ExerciseDTO;
import com.lexlopee.sportfood.dto.ejercicio.ExerciseResponseDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class TheExerciseDbService {
    private final RestClient theExerciseDbClient;

    public TheExerciseDbService(@Qualifier("theExcerciseDbClient")RestClient theExerciseDbClient) {
        this.theExerciseDbClient = theExerciseDbClient;
    }
    public List<ExerciseDTO> listarEjercicios (){
        ExerciseResponseDTO respuesta = theExerciseDbClient.get()
                .uri("/exercises")
                .retrieve()
                .body(ExerciseResponseDTO.class);
        return respuesta.getData();
    }
}
