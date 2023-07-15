package com.zenbet.zenbetapi.service;

import com.zenbet.zenbetapi.domain.Partido;
import java.util.List;

public interface PartidoService {
    List<Partido> listarAllPartidos();

    Partido crearPatido(Partido partido);

    void eliminarPartido(Long idPartido);

    Partido actualizarPartido(Partido partido);

}
