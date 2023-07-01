package com.zenbet.zenbetapi.service;

import com.zenbet.zenbetapi.domain.Apostador;

import java.util.List;
import java.util.Optional;

public interface ApostadorService {
    Apostador crearApostador(Apostador apostador);

    List<Apostador> listarApostadores();

    Apostador actualizarApostador(Apostador apostador);

    void eliminarApostador(Long dni);

    Optional<Apostador> buscarPorDni(Long dni);

    Apostador findByDniAndContrasena(Long dni, String contrasena);


    Apostador incrementarSaldo(Long dni, float cantidad);

}
