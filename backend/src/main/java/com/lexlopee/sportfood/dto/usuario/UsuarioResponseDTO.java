package com.lexlopee.sportfood.dto.usuario;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class UsuarioResponseDTO {
    private Integer idUsuario;
    private String correo;
    private String nombreUsuario;
    private String genero;
    private BigDecimal altura;
    private BigDecimal peso;
    private String fotoPerfil;
    private LocalDate fechaNacimiento;
}
