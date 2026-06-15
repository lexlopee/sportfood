package com.lexlopee.sportfood.entity.musica;


import com.lexlopee.sportfood.entity.RutinaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "musica")

public class MusicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_playlist")
    private Integer idPlaylist;
    @Column(name = "playlist")
    private String playlist;
    @Column(name = "duracion")
    private Integer duracion;
    @ManyToOne
    @JoinColumn(name = "id_rutina")
    private RutinaEntity rutinaEntity;

}
