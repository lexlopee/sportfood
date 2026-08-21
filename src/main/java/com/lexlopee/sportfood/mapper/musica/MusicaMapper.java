package com.lexlopee.sportfood.mapper.musica;

import com.lexlopee.sportfood.dto.musica.MusicaResponseDTO;
import com.lexlopee.sportfood.entity.musica.MusicaEntity;
import org.springframework.stereotype.Component;

@Component
public class MusicaMapper {
    public MusicaResponseDTO toResponseDTO(MusicaEntity entity) {
        MusicaResponseDTO dto = new MusicaResponseDTO();

        dto.setIdPlaylist(entity.getIdPlaylist());
        dto.setPlaylist(entity.getPlaylist());
        dto.setDuracion(entity.getDuracion());
        dto.setIdRutina(entity.getRutinaEntity().getIdRutina());

        return dto;
    }
}
