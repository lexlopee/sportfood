package com.lexlopee.sportfood.controller.comida;

import com.lexlopee.sportfood.entity.comida.ComidaEntity;
import com.lexlopee.sportfood.service.comida.ComidaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/food")
public class ComidaController {

    private final ComidaService comidaService;

    public ComidaController(ComidaService comidaService) {
        this.comidaService = comidaService;
    }

    @GetMapping
    public List<ComidaEntity> findAll(){
        return comidaService.findAll();
    }
    @GetMapping("/{id}")
    public ComidaEntity findByAll (@PathVariable Integer id){
        return comidaService.findById(id);
    }
    @PostMapping
    public ComidaEntity save (@RequestBody ComidaEntity comida){
        return comidaService.save(comida);
    }
    @DeleteMapping("/{id}")
    public void delete (Integer id){
        comidaService.delete(id);
    }
}

