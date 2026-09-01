package com.lexlopee.sportfood.entity.progreso;

import com.lexlopee.sportfood.entity.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "progreso")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ProgresoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progreso")
    private Integer idProgreso;
    @Column(name = "ranking")
    private Integer ranking;
    @Column(name = "entrenamientos_completados")
    private Integer entrenamientosCompletados;
    @Column(name = "dias_entrenados")
    private Integer diasEntrenados;
    @Column(name = "peso_actual")
    private BigDecimal pesoActual;
    @Column(name = "puntos_experiencia")
    private BigDecimal puntosExperiencia;
    @Column(name = "peso_objetivo")
    private BigDecimal pesoObjetivo;
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuarioEntity;

}
