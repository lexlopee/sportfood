package com.lexlopee.sportfood.controller.musica;

import com.lexlopee.sportfood.dto.musica.MusicaResponseDTO;
import com.lexlopee.sportfood.entity.musica.MusicaEntity;
import com.lexlopee.sportfood.mapper.musica.MusicaMapper;
import com.lexlopee.sportfood.service.musica.MusicaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/music")
public class MusicaController {
    private final MusicaService musicaService;
    private final MusicaMapper musicaMapper;

    public MusicaController(MusicaService musicaService, MusicaMapper musicaMapper) {
        this.musicaService = musicaService;
        this.musicaMapper = musicaMapper;
    }

    @GetMapping
    public List<MusicaResponseDTO> findAll() {
        return musicaService.findAll().stream()
                .map(musicaMapper::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public MusicaResponseDTO findById(@PathVariable Integer id) {
        return musicaMapper.toResponseDTO(musicaService.findById(id));
    }

    @PostMapping
    public MusicaResponseDTO save(@RequestBody MusicaEntity musica) {
        return musicaMapper.toResponseDTO(musicaService.save(musica));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        musicaService.delete(id);
    }
}
