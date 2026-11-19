package com.lexlopee.sportfood.entity.rutina;

import com.lexlopee.sportfood.entity.ejercicio.EjercicioEntity;
import com.lexlopee.sportfood.entity.usuario.UsuarioEntity;
import jakarta.validation.constraints.Min;
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
    @Min(value = 1, message = "El tiempo debe ser mayor que 0")
    @Column(name = "tiempo")
    private Integer tiempo;
    @Column (name = "nombre")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuarioEntity;
    @ManyToMany
    @JoinTable(
            name = "ejercicio_contiene_rutina",
            joinColumns = @JoinColumn(name = "id_rutina"),
            inverseJoinColumns = @JoinColumn(name = "id_ejercicio")
    )
    private List<EjercicioEntity> ejercicios;
}
