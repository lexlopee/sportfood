package com.lexlopee.sportfood.service.usuario;

import com.lexlopee.sportfood.config.security.JwtService;
import com.lexlopee.sportfood.dto.usuario.LoginResponseDTO;
import com.lexlopee.sportfood.entity.comida.ComidaEntity;
import com.lexlopee.sportfood.entity.usuario.UsuarioEntity;
import com.lexlopee.sportfood.repository.usuario.UsuarioRepository;
import com.lexlopee.sportfood.service.comida.ComidaService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ComidaService comidaService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    //Contructor del Repository
    public UsuarioService(UsuarioRepository usuarioRepository, ComidaService comidaService, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.comidaService = comidaService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
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

    public UsuarioEntity guardarComidaFavorita(Integer idUsuario, String idExterno) {
        UsuarioEntity usuario = usuarioRepository.findById(idUsuario).orElse(null);
        ComidaEntity comida = comidaService.guardarPorIdExterno(idExterno);

        if (!usuario.getComidas().contains(comida)) {
            usuario.getComidas().add(comida);
        }

        return usuarioRepository.save(usuario);
    }

    public List<ComidaEntity> listarComidasFavoritas(Integer idUsuario) {
        UsuarioEntity usuario = usuarioRepository.findById(idUsuario).orElse(null);
        return usuario.getComidas();
    }

    public UsuarioEntity registrar(UsuarioEntity usuario) {
        String hash = passwordEncoder.encode(usuario.getContrasenia());
        usuario.setContrasenia(hash);
        return usuarioRepository.save(usuario);
    }

    public LoginResponseDTO login(String correo, String contrasenia) {
        UsuarioEntity usuario = usuarioRepository.findByCorreo(correo).orElse(null);
        if (usuario == null) {
            return null;
        }
        if (!passwordEncoder.matches(contrasenia, usuario.getContrasenia())) {
            return null;
        }
        String token = jwtService.generarToken(correo);
        return new LoginResponseDTO(token, usuario.getIdUsuario());
    }

}
