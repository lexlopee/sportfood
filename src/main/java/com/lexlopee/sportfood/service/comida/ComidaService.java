package com.lexlopee.sportfood.service.comida;

import com.lexlopee.sportfood.entity.comida.ComidaEntity;
import com.lexlopee.sportfood.repository.comida.ComidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComidaService {

    private final ComidaRepository comidaRepository;

    public ComidaService(ComidaRepository comidaRepository) {
        this.comidaRepository = comidaRepository;
    }

    public List<ComidaEntity> findAll() {
        return comidaRepository.findAll();
    }

    public ComidaEntity findById(Integer id) {
        return comidaRepository.findById(id).orElse(null);
    }

    public ComidaEntity save(ComidaEntity comida) {
        return comidaRepository.save(comida);
    }

    public void delete(Integer id) {
        comidaRepository.deleteById(id);
    }
}
