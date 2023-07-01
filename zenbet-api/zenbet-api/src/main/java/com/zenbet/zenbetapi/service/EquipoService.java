package com.zenbet.zenbetapi.service;

import com.zenbet.zenbetapi.domain.Competencia;
import com.zenbet.zenbetapi.domain.Equipo;

import java.util.List;
import java.util.Optional;

public interface EquipoService {

    Equipo crearEquipo(Equipo equipo);

    List<Equipo> listarAllEquipos();

    Equipo actualizarEquipo( Equipo equipo);

    void eliminarEquipo(Long idEquipo);

    Optional<Equipo> buscarPorId(Long idEquipo);

}
