package com.lexlopee.sportfood.mapper.rutina;

import com.lexlopee.sportfood.dto.rutina.RutinaResponseDTO;
import com.lexlopee.sportfood.entity.rutina.RutinaEntity;
import org.springframework.stereotype.Component;

@Component
public class RutinaMapper {

    public RutinaResponseDTO toResponseDTO (RutinaEntity entity){
        RutinaResponseDTO dto = new RutinaResponseDTO();
        dto.setIdRutina(entity.getIdRutina());
        dto.setTiempo(entity.getTiempo());
        dto.setIdUsuario(entity.getUsuarioEntity().getIdUsuario());
        return dto;
    }
}
