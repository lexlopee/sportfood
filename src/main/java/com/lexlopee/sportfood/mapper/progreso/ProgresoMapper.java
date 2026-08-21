package com.lexlopee.sportfood.mapper.progreso;

import com.lexlopee.sportfood.dto.progreso.ProgresoResponseDTO;
import com.lexlopee.sportfood.entity.progreso.ProgresoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProgresoMapper {
    public ProgresoResponseDTO toResponseDTO(ProgresoEntity entity) {
        ProgresoResponseDTO dto = new ProgresoResponseDTO();

        dto.setIdProgreso(entity.getIdProgreso());
        dto.setRanking(entity.getRanking());
        dto.setEntrenamientosCompletados(entity.getEntrenamientosCompletados());
        dto.setDiasEntrenados(entity.getDiasEntrenados());
        dto.setPesoActual(entity.getPesoActual());
        dto.setPuntosExperiencia(entity.getPuntosExperiencia());
        dto.setPesoObjetivo(entity.getPesoObjetivo());
        dto.setFechaActualizacion(entity.getFechaActualizacion());
        dto.setIdUsuario(entity.getUsuarioEntity().getIdUsuario());
        return dto;
    }
}
