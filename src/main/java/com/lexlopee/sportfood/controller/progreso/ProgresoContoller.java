package com.lexlopee.sportfood.controller.progreso;

import com.lexlopee.sportfood.dto.progreso.ProgresoResponseDTO;
import com.lexlopee.sportfood.entity.progreso.ProgresoEntity;
import com.lexlopee.sportfood.mapper.progreso.ProgresoMapper;
import com.lexlopee.sportfood.service.progreso.ProgresoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/progress")
public class ProgresoContoller {

    private final ProgresoService progresoService;
    private final ProgresoMapper progresoMapper;


    public ProgresoContoller(ProgresoService progresoService, ProgresoMapper progresoMapper) {
        this.progresoService = progresoService;
        this.progresoMapper = progresoMapper;
    }

    @GetMapping
    public List<ProgresoResponseDTO> findAll(){
        return progresoService.findAll().stream()
                .map(progresoMapper::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ProgresoResponseDTO findById (@PathVariable Integer id){
        return progresoMapper.toResponseDTO(progresoService.findById(id));
    }

    @PostMapping
    public ProgresoResponseDTO save (@RequestBody ProgresoEntity progreso){
        return progresoMapper.toResponseDTO(progresoService.save(progreso));
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        progresoService.delete(id);
    }
}
