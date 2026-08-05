package com.lexlopee.sportfood.controller.rutina;

import com.lexlopee.sportfood.dto.rutina.RutinaResponseDTO;
import com.lexlopee.sportfood.entity.rutina.RutinaEntity;
import com.lexlopee.sportfood.entity.usuario.UsuarioEntity;
import com.lexlopee.sportfood.mapper.rutina.RutinaMapper;
import com.lexlopee.sportfood.service.rutina.RutinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/routines")
public class RutinaController {

    private final RutinaService rutinaService;
    private final RutinaMapper rutinaMapper;

    public RutinaController(RutinaService rutinaService, RutinaMapper rutinaMapper) {
        this.rutinaService = rutinaService;
        this.rutinaMapper = rutinaMapper;
    }

    @GetMapping
    public List<RutinaResponseDTO> findAll() {
        return rutinaService.findAll().stream()
                .map(rutinaMapper::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public RutinaResponseDTO findById(@PathVariable Integer id) {
        return rutinaMapper.toResponseDTO(rutinaService.findById(id));
    }

    @PostMapping
    public RutinaResponseDTO save (@RequestBody RutinaEntity rutina){
        return rutinaMapper.toResponseDTO(rutinaService.save(rutina));    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        rutinaService.delete(id);
    }

}
