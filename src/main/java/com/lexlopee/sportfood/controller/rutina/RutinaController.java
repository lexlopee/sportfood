package com.lexlopee.sportfood.controller.rutina;

import com.lexlopee.sportfood.entity.rutina.RutinaEntity;
import com.lexlopee.sportfood.entity.usuario.UsuarioEntity;
import com.lexlopee.sportfood.service.rutina.RutinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rutina")
public class RutinaController {

    private final RutinaService rutinaService;

    public RutinaController(RutinaService rutinaService) {
        this.rutinaService = rutinaService;
    }

    @GetMapping
    public List<RutinaEntity> findAll() {
        return rutinaService.findAll();
    }

    @GetMapping("/{id}")
    public RutinaEntity findById(@PathVariable Integer id) {
        return rutinaService.findById(id);
    }

    @PostMapping
    public RutinaEntity save (@RequestBody RutinaEntity rutina){
        return rutinaService.save(rutina);
    }

    @DeleteMapping("/{id}")
    public void delete (Integer id){
        rutinaService.delete(id);
    }

}
