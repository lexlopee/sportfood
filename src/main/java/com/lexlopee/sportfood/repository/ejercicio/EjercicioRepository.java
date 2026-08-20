package com.lexlopee.sportfood.repository.ejercicio;

import com.lexlopee.sportfood.entity.ejercicio.EjercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EjercicioRepository extends JpaRepository<EjercicioEntity, Integer> {
    Optional<EjercicioEntity> findByIdExterno(String integer);
}
