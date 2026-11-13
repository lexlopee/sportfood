package com.lexlopee.sportfood.service.comida;

import com.lexlopee.sportfood.dto.comida.MealDTO;
import com.lexlopee.sportfood.entity.comida.ComidaEntity;
import com.lexlopee.sportfood.repository.comida.ComidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComidaService {

    private final ComidaRepository comidaRepository;
    private final TheMealDbService theMealDbService;

    public ComidaService(ComidaRepository comidaRepository, TheMealDbService theMealDbService) {
        this.comidaRepository = comidaRepository;
        this.theMealDbService = theMealDbService;
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

    public ComidaEntity guardarPorIdExterno(String idExterno) {
        return comidaRepository.findByIdExterno(idExterno)
                .orElseGet(() -> {
                    ComidaEntity nueva = new ComidaEntity();
                    nueva.setIdExterno(idExterno);

                    MealDTO meal = theMealDbService.buscarPorId(idExterno);
                    if (meal != null) {
                        nueva.setNombre(meal.getNombre());
                    }

                    return comidaRepository.save(nueva);
                });
    }
}