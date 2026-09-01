package com.lexlopee.sportfood.repository.comida;

import com.lexlopee.sportfood.entity.comida.ComidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComidaRepository extends JpaRepository<ComidaEntity, Integer> {
    Optional<ComidaEntity> findByIdExterno(String idExterno);
}
