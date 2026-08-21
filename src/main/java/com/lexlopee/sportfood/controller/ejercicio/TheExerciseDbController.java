package com.lexlopee.sportfood.controller.ejercicio;

import com.lexlopee.sportfood.dto.ejercicio.ExerciseDTO;
import com.lexlopee.sportfood.service.ejercicio.TheExerciseDbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exercisedb")
public class TheExerciseDbController {
    private final TheExerciseDbService theExerciseDbService;

    public TheExerciseDbController(TheExerciseDbService theExerciseDbService) {
        this.theExerciseDbService = theExerciseDbService;
    }

    @GetMapping
    public List<ExerciseDTO> listarEjercicios() {
        return theExerciseDbService.listarEjercicios();
    }
}
