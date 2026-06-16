package com.lexlopee.sportfood.controller.progreso;

import com.lexlopee.sportfood.entity.progreso.ProgresoEntity;
import com.lexlopee.sportfood.service.progreso.ProgresoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/progress")
public class ProgresoContoller {

    private final ProgresoService progresoService;


    public ProgresoContoller(ProgresoService progresoService) {
        this.progresoService = progresoService;
    }

    @GetMapping
    public List<ProgresoEntity> findAll(){
        return progresoService.findAll();
    }

    @GetMapping("/{id}")
    public ProgresoEntity findById (@PathVariable Integer id){
        return progresoService.findById(id);
    }

    @PostMapping
    public ProgresoEntity save (@RequestBody ProgresoEntity progreso){
        return progresoService.save(progreso);
    }

    @DeleteMapping("/{id}")
    public void delete (Integer id){
        progresoService.delete(id);
    }
}
