package com.zenbet.zenbetapi.service.impl;

import com.zenbet.zenbetapi.domain.Apostador;
import com.zenbet.zenbetapi.repository.ApostadorRepository;
import com.zenbet.zenbetapi.service.ApostadorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApostadorServiceImpl implements ApostadorService {
    private final ApostadorRepository apostadorRepository;

    public ApostadorServiceImpl(ApostadorRepository apostadorRepository){
        this.apostadorRepository = apostadorRepository;
    }

    @Override
    public Apostador crearApostador(Apostador apostador) {
        if(apostadorRepository.findById(apostador.getDni()).isEmpty())
            return apostadorRepository.save(apostador);
        else return null;
    }

    @Override
    public List<Apostador> listarApostadores() {
        return apostadorRepository.findAll();
    }

    @Override
    public Apostador actualizarApostador(Apostador apostador) {
        Apostador aposToUpdate = apostadorRepository.findById(apostador.getDni()).orElse(null);
        if(aposToUpdate != null) {
            aposToUpdate.setNombre(apostador.getNombre());
            aposToUpdate.setTelefono(apostador.getTelefono());
            aposToUpdate.setCorreo(apostador.getCorreo());
            aposToUpdate.setDireccion(apostador.getDireccion());
            aposToUpdate.setContrasena(apostador.getContrasena());
            return apostadorRepository.save(aposToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarApostador(Long dni) {
        apostadorRepository.deleteById(dni);
    }

    public Optional<Apostador> buscarPorDni(Long dni) {
        return apostadorRepository.findById(dni);
    }

    public Apostador findByDniAndContrasena(Long dni, String contrasena) {
        return apostadorRepository.findByDniAndContrasena(dni, contrasena);
    }

    //Borrar de aca para adelante
    @Override
    public Apostador incrementarSaldo(Long dni, float cantidad) {
        Apostador apostador = apostadorRepository.findById(dni).orElse(null);
        if (apostador != null) {
            float montoActual = apostador.getSaldo();
            float nuevoMonto = montoActual + cantidad;
            apostador.setSaldo(nuevoMonto);
            return apostadorRepository.save(apostador);
        } else {
            return null;
        }
    }


}
