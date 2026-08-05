package com.lexlopee.sportfood.mapper.ejercicio;

import com.lexlopee.sportfood.dto.ejercicio.EjercicioResponseDTO;
import com.lexlopee.sportfood.entity.ejercicio.EjercicioEntity;
import org.springframework.stereotype.Component;

@Component
public class EjercicioMapper {
    public EjercicioResponseDTO toResponseDTO (EjercicioEntity entity) {
        EjercicioResponseDTO dto = new EjercicioResponseDTO();

        dto.setIdEjercicio(entity.getIdEjercicio());
        dto.setIdExterno(entity.getIdExterno());
        return dto;
    }
}
