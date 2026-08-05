package com.lexlopee.sportfood.mapper.comida;

import com.lexlopee.sportfood.dto.comida.ComidaResponseDTO;
import com.lexlopee.sportfood.entity.comida.ComidaEntity;
import org.springframework.stereotype.Component;

@Component
public class ComidaMapper {
    public ComidaResponseDTO toResponseDTO (ComidaEntity entity) {
        ComidaResponseDTO dto = new ComidaResponseDTO();
        dto.setIdComida(entity.getIdComida());
        dto.setIdExterno(entity.getIdExterno());
        return dto;
    }
}
