package com.zenbet.zenbetapi.service;

import com.zenbet.zenbetapi.domain.Apostador;

import java.util.List;

public interface ApostadorService {
    Apostador crearApostador(Apostador apostador);

    List<Apostador> listarApostadores();
}
