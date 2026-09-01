package com.lexlopee.sportfood.service.musica;

import com.lexlopee.sportfood.entity.musica.MusicaEntity;
import com.lexlopee.sportfood.repository.musica.MusicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    private final MusicaRepository musicaRepository;

    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    public List<MusicaEntity> findAll() {
        return musicaRepository.findAll();
    }

    public MusicaEntity findById(Integer id) {
        return musicaRepository.findById(id).orElse(null);
    }

    public MusicaEntity save(MusicaEntity musica) {
        return musicaRepository.save(musica);
    }

    public void delete(Integer id) {
        musicaRepository.deleteById(id);
    }
}
