package com.zenbet.zenbetapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name= "equipos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipo;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombreEquipo;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacionEquipo;

}