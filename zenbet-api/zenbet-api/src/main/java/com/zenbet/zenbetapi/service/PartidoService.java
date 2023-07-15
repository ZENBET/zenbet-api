package com.zenbet.zenbetapi.service;

import com.zenbet.zenbetapi.domain.Equipo;
import com.zenbet.zenbetapi.domain.Partido;
import java.util.List;
import java.util.Optional;

public interface PartidoService {
    List<Partido> listarAllPartidos();

    Partido crearPatido(Partido partido);

    void eliminarPartido(Long idPartido);

    Partido actualizarPartido(Partido partido);

    Optional<Partido> buscarPorId(Long idPartido);

}
