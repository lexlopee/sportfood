package com.lexlopee.sportfood.entity;

import com.lexlopee.sportfood.entity.ejercicio.EjercicioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rutina")

public class RutinaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rutina")
    private Integer idRutina;
    @Column(name = "tiempo")
    private Integer tiempo;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuarioEntity;
    @ManyToMany
    @JoinTable(
            name = "ejercicio_contiene_rutinas",
            joinColumns = @JoinColumn(name = "id_rutina"),
            inverseJoinColumns = @JoinColumn(name = "id_ejercicio")
    )
    private List<EjercicioEntity> ejercicios;
}
