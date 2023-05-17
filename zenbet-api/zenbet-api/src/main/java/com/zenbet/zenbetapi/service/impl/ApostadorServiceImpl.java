package com.zenbet.zenbetapi.service.impl;

import com.zenbet.zenbetapi.domain.Apostador;
import com.zenbet.zenbetapi.repository.ApostadorRepository;
import com.zenbet.zenbetapi.service.ApostadorService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
