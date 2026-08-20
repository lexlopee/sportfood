package com.lexlopee.sportfood.service.rutina;

import com.lexlopee.sportfood.entity.ejercicio.EjercicioEntity;
import com.lexlopee.sportfood.entity.rutina.RutinaEntity;
import com.lexlopee.sportfood.repository.rutina.RutinaRepository;
import com.lexlopee.sportfood.service.ejercicio.EjercicioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaService {
    private final RutinaRepository rutinaRepository;
    private final EjercicioService ejercicioService;

    public RutinaService(RutinaRepository rutinaRepository, EjercicioService ejercicioService) {
        this.rutinaRepository = rutinaRepository;
        this.ejercicioService = ejercicioService;
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

    public RutinaEntity añadirEjercicio (Integer idRutina, String idExterno) {
        RutinaEntity rutina = rutinaRepository.findById(idRutina).orElse(null);
        EjercicioEntity ejercicio = ejercicioService.guardarPorIdExterno(idExterno);
        rutina.getEjercicios().add(ejercicio);
        return  rutinaRepository.save(rutina);
    }
    public List<EjercicioEntity> listarEjercicios(Integer idRutina){
        RutinaEntity rutina = rutinaRepository.findById(idRutina).orElse(null);
        return rutina.getEjercicios();
    }
}
