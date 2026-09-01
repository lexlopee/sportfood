package com.lexlopee.sportfood.controller.comida;

import com.lexlopee.sportfood.dto.comida.ComidaResponseDTO;
import com.lexlopee.sportfood.entity.comida.ComidaEntity;
import com.lexlopee.sportfood.mapper.comida.ComidaMapper;
import com.lexlopee.sportfood.service.comida.ComidaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
public class ComidaController {

    private final ComidaService comidaService;
    private final ComidaMapper comidaMapper;

    public ComidaController(ComidaService comidaService, ComidaMapper comidaMapper) {
        this.comidaService = comidaService;
        this.comidaMapper = comidaMapper;
    }

    @GetMapping
    public List<ComidaResponseDTO> findAll() {
        return comidaService.findAll().stream()
                .map(comidaMapper::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ComidaResponseDTO findByAll(@PathVariable Integer id) {
        return comidaMapper.toResponseDTO(comidaService.findById(id));
    }

    @PostMapping
    public ComidaResponseDTO save(@RequestBody ComidaEntity comida) {
        return comidaMapper.toResponseDTO(comidaService.save(comida));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        comidaService.delete(id);
    }

    @PostMapping("/guardar")
    public ComidaResponseDTO guardarPorIdExterno(@RequestParam("idExterno") String idExterno) {
        ComidaEntity comida = comidaService.guardarPorIdExterno(idExterno);
        return comidaMapper.toResponseDTO(comida);
    }

}
