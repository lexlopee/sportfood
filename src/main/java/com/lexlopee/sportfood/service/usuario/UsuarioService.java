package com.lexlopee.sportfood.service.usuario;

import com.lexlopee.sportfood.entity.comida.ComidaEntity;
import com.lexlopee.sportfood.entity.usuario.UsuarioEntity;
import com.lexlopee.sportfood.repository.usuario.UsuarioRepository;
import com.lexlopee.sportfood.service.comida.ComidaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ComidaService comidaService;

    //Contructor del Repository
    public UsuarioService(UsuarioRepository usuarioRepository, ComidaService comidaService) {
        this.usuarioRepository = usuarioRepository;
        this.comidaService = comidaService;
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

    public UsuarioEntity guardarComidaFavorita(Integer idUsuario, String idExterno){
        // Busca al usuario
        UsuarioEntity usuario = usuarioRepository.findById(idUsuario).orElse(null);
        // Guarda la comida
        ComidaEntity comida = comidaService.guardarPorIdExterno(idExterno);
        // Añade esa comida a la lista de favoritas del usuario
        usuario.getComidas().add(comida);
        // Guarda el usuario
        return usuarioRepository.save(usuario);
    }
}
