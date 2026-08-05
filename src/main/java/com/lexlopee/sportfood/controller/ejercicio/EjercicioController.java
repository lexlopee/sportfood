package com.lexlopee.sportfood.controller.ejercicio;

import com.lexlopee.sportfood.dto.ejercicio.EjercicioResponseDTO;
import com.lexlopee.sportfood.entity.ejercicio.EjercicioEntity;
import com.lexlopee.sportfood.mapper.ejercicio.EjercicioMapper;
import com.lexlopee.sportfood.service.ejercicio.EjercicioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/exercises")
public class EjercicioController {

    private final EjercicioService ejercicioService;
    private final EjercicioMapper ejercicioMapper;

    public EjercicioController(EjercicioService ejercicioService, EjercicioMapper ejercicioMapper) {
        this.ejercicioService = ejercicioService;
        this.ejercicioMapper = ejercicioMapper;
    }

    @GetMapping
    public List<EjercicioResponseDTO> findAll (){
        return ejercicioService.findAll().stream()
                .map(ejercicioMapper::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public EjercicioResponseDTO findById (@PathVariable Integer id){
        return ejercicioMapper.toResponseDTO(ejercicioService.findById(id));
    }

    @PostMapping
    public EjercicioResponseDTO save (@RequestBody EjercicioEntity ejercicio){
        return ejercicioMapper.toResponseDTO(ejercicioService.save(ejercicio));
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        ejercicioService.delete(id);
    }
}
