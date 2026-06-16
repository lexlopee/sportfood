package com.lexlopee.sportfood.controller.ejercicio;

import com.lexlopee.sportfood.entity.ejercicio.EjercicioEntity;
import com.lexlopee.sportfood.service.ejercicio.EjercicioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/v1/ejercicio")
public class EjercicioController {

    private final EjercicioService ejercicioService;

    public EjercicioController(EjercicioService ejercicioService) {
        this.ejercicioService = ejercicioService;
    }

    @GetMapping
    public List<EjercicioEntity> findAll (){
        return ejercicioService.findAll();
    }

    @GetMapping("/{id}")
    public EjercicioEntity findById (@PathVariable Integer id){
        return ejercicioService.findById(id);
    }

    @PostMapping
    public EjercicioEntity save (@RequestBody EjercicioEntity ejercicio){
        return ejercicioService.save(ejercicio);
    }

    @DeleteMapping("/{id}")
    public void delete (Integer id){
        ejercicioService.delete(id);
    }
}
