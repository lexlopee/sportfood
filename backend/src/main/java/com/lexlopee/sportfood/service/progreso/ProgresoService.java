package com.lexlopee.sportfood.service.progreso;

import com.lexlopee.sportfood.entity.progreso.ProgresoEntity;
import com.lexlopee.sportfood.repository.progreso.ProgresoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgresoService {

    private final ProgresoRepository progresoRepository;

    public ProgresoService(ProgresoRepository progresoRepository) {
        this.progresoRepository = progresoRepository;
    }

    public List<ProgresoEntity> findAll() {
        return progresoRepository.findAll();
    }

    public ProgresoEntity findById(Integer id) {
        return progresoRepository.findById(id).orElse(null);
    }

    public ProgresoEntity save(ProgresoEntity progreso) {
        return progresoRepository.save(progreso);
    }

    public void delete(Integer id) {
        progresoRepository.deleteById(id);
    }
}
