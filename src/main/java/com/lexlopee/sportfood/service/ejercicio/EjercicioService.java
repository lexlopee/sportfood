package com.lexlopee.sportfood.service.ejercicio;

import com.lexlopee.sportfood.entity.ejercicio.EjercicioEntity;
import com.lexlopee.sportfood.repository.ejercicio.EjercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {
    private final EjercicioRepository ejercicioRepository;

    public EjercicioService(EjercicioRepository ejercicioRepository) {
        this.ejercicioRepository = ejercicioRepository;
    }

    public List<EjercicioEntity> findAll() {
        return ejercicioRepository.findAll();
    }

    public EjercicioEntity findById(Integer id) {
        return ejercicioRepository.findById(id).orElse(null);
    }

    public EjercicioEntity save(EjercicioEntity ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    public void delete(Integer id) {
        ejercicioRepository.deleteById(id);
    }
}
