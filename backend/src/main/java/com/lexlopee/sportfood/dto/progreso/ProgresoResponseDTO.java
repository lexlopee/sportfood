package com.lexlopee.sportfood.dto.progreso;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProgresoResponseDTO {
    private Integer idProgreso;
    private Integer ranking;
    private Integer entrenamientosCompletados;
    private Integer diasEntrenados;
    private BigDecimal pesoActual;
    private BigDecimal puntosExperiencia;
    private BigDecimal pesoObjetivo;
    private LocalDateTime fechaActualizacion;
    private Integer idUsuario;
}

