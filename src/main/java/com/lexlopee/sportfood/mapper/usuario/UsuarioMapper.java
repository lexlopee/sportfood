package com.lexlopee.sportfood.mapper.usuario;

import com.lexlopee.sportfood.dto.usuario.UsuarioResponseDTO;
import com.lexlopee.sportfood.entity.usuario.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioResponseDTO toResponseDTO (UsuarioEntity entity){
        UsuarioResponseDTO dto = new UsuarioResponseDTO();

        dto.setIdUsuario(entity.getIdUsuario());
        dto.setCorreo(entity.getCorreo());
        dto.setNombreUsuario(entity.getNombreUsuario());
        dto.setGenero(entity.getGenero());
        dto.setAltura(entity.getAltura());
        dto.setPeso(entity.getPeso());
        dto.setFotoPerfil(entity.getFotoPerfil());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        return dto;
    }
}
