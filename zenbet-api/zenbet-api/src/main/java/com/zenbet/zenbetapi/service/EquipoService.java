package com.zenbet.zenbetapi.service;

import com.zenbet.zenbetapi.domain.Equipo;

import java.util.List;
public interface EquipoService {

    Equipo crearEquipo(Equipo equipo);

    List<Equipo> listarAllEquipos();

    Equipo actualizarEquipo( Equipo equipo);
}
