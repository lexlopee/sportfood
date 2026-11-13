package com.lexlopee.sportfood.entity.comida;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "comida")

public class ComidaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comida")
    private Integer idComida;
    @Column(name = "id_externo")
    private String idExterno;
    @Column (name = "nombre")
    private String nombre;
}
