package com.lexlopee.sportfood.entity;

import com.lexlopee.sportfood.entity.comida.ComidaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "usuario")

public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "correo")
    private String correo;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "genero")
    private String genero;
    @Column(name = "altura")
    private BigDecimal altura;
    @Column(name = "peso")
    private BigDecimal peso;
    @Column(name = "foto_perfil")
    private String fotoPerfil;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "contrasenia_hash")
    private String contrasenia;
    @ManyToMany
    @JoinTable(
            name = "comida_tiene_usuario",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_comida")
    )
    private List<ComidaEntity> comidas;

}
