package com.lexlopee.sportfood.repository.rutina;

import com.lexlopee.sportfood.entity.rutina.RutinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutinaRepository extends JpaRepository<RutinaEntity, Integer> {
    List<RutinaEntity> findByUsuarioEntity_IdUsuario(Integer idUsuario);
}
