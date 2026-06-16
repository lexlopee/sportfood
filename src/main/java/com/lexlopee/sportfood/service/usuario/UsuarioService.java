package com.lexlopee.sportfood.service.usuario;

import com.lexlopee.sportfood.entity.usuario.UsuarioEntity;
import com.lexlopee.sportfood.repository.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    //Contructor del Repository
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Listar todod los usuarios
    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    //Buscar un usuario por id
    public UsuarioEntity findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Guardar un usuario
    public UsuarioEntity save(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    //Borrar un usuario por id
    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
