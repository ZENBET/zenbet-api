package com.zenbet.zenbetapi.service;

import com.zenbet.zenbetapi.domain.Administrador;

import java.util.List;

public interface AdministradorService {
    Administrador crearAdministrador(Administrador administrador);

    List<Administrador> listarAdministradores();

    Administrador actualizarAdministrador(Administrador administrador);

    void eliminarAdministrador(Long dni);

}
