package com.lexlopee.sportfood.repository.usuario;

import com.lexlopee.sportfood.entity.usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
}
