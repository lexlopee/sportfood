package com.lexlopee.sportfood.controller.musica;

import com.lexlopee.sportfood.entity.musica.MusicaEntity;
import com.lexlopee.sportfood.service.musica.MusicaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/music")
public class MusicaController {
    private final MusicaService musicaService;

    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    @GetMapping
    public List<MusicaEntity> findAll(){
        return musicaService.findAll();
    }

    @GetMapping("/{id}")
    public MusicaEntity findById(@PathVariable Integer id){
        return musicaService.findById(id);
    }

    @PostMapping
    public MusicaEntity save (@RequestBody MusicaEntity musica){
        return musicaService.save(musica);
    }

    @DeleteMapping("/{id}")
    public void delete (Integer id){
        musicaService.delete(id);
    }
}
