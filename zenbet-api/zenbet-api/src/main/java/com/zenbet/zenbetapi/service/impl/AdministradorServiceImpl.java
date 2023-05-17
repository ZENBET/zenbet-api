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

    @Override
    public Administrador actualizarAdministrador(Administrador administrador) {
        Administrador adminToUpdate = administradorRepository.findById(administrador.getDni()).orElse(null);
        if(adminToUpdate != null) {
            adminToUpdate.setNombre(administrador.getNombre());
            adminToUpdate.setTelefono(administrador.getTelefono());
            adminToUpdate.setCorreo(administrador.getCorreo());
            adminToUpdate.setDireccion(administrador.getDireccion());
            adminToUpdate.setContrasena(administrador.getContrasena());
            return administradorRepository.save(adminToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarAdministrador(Long dni) {
        administradorRepository.deleteById(dni);
    }
}
