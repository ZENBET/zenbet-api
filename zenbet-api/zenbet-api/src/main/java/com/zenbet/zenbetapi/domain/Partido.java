package com.zenbet.zenbetapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Partidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPartido;
    @ManyToOne
    @JoinColumn(name = "id_Equipo1", nullable = false, foreignKey = @ForeignKey(name = "FK_Partido_Equipo1"))
    private Equipo equipo1;


    @ManyToOne
    @JoinColumn(name = "id_Equipo2", nullable = false, foreignKey = @ForeignKey(name = "FK_Partido_Equipo2"))
    private Equipo equipo2;


    @ManyToOne
    @JoinColumn(name = "id_Competencia", nullable = false, foreignKey = @ForeignKey(name = "FK_Partido_Competencia"))
    private Competencia competencia;


    @Column(name = "Cuota_Equipo1", nullable = false)
    private Long cuotaEquipo1;


    @Column(name = "Cuota_Equipo2", nullable = false)
    private Long cuotaEquipo2;


    @Column(name = "Cuota_EquipoEmpate", nullable = false)
    private Long cuotaEmpate;

}
