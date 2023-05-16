package com.zenbet.zenbetapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Usuario {
    @Id
    @Column(name="dni")
    private Long dni;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="telefono", nullable = false)
    private String telefono;

    @Column(name="correo", nullable = false)
    private String correo;

    @Column(name="direccion", nullable = false)
    private String direccion;

    @Column(name="contrasena", nullable = false)
    private String contrasena;
}
