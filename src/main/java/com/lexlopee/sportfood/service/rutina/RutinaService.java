package com.lexlopee.sportfood.service.rutina;

import com.lexlopee.sportfood.entity.rutina.RutinaEntity;
import com.lexlopee.sportfood.repository.rutina.RutinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaService {
    private final RutinaRepository rutinaRepository;

    public RutinaService(RutinaRepository rutinaRepository) {
        this.rutinaRepository = rutinaRepository;
    }


    public List<RutinaEntity> findAll() {
        return rutinaRepository.findAll();
    }

    public RutinaEntity findById(Integer id) {
        return rutinaRepository.findById(id).orElse(null);
    }

    public RutinaEntity save(RutinaEntity rutina) {
        return rutinaRepository.save(rutina);
    }

    public void delete(Integer id) {
        rutinaRepository.deleteById(id);
    }
}
