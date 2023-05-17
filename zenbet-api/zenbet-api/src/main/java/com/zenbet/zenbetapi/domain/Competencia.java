package com.zenbet.zenbetapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name= "competencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Competencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompetencia;

    @Column(name = "nombreCompetencia", nullable = false, unique = true)
    private String nombreCompetencia;

    @Column(name = "fechaInicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fechaFin", nullable = false)
    private Date fechaFin;
}
