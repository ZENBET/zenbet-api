package com.zenbet.zenbetapi.service.impl;

import com.zenbet.zenbetapi.domain.Administrador;
import com.zenbet.zenbetapi.repository.AdministradorRepository;
import com.zenbet.zenbetapi.service.AdministradorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorServiceImpl implements AdministradorService {
    private final AdministradorRepository administradorRepository;

    public AdministradorServiceImpl(AdministradorRepository administradorRepository){
        this.administradorRepository = administradorRepository;
    }
    @Override
    public Administrador crearAdministrador(Administrador administrador) {
        if(administradorRepository.findById(administrador.getDni()).isEmpty())
            return administradorRepository.save(administrador);
        else return null;
    }

    @Override
    public List<Administrador> listarAdministradores() {
        return administradorRepository.findAll();
    }
}
