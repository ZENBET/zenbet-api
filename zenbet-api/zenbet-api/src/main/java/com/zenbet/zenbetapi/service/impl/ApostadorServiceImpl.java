package com.zenbet.zenbetapi.service.impl;

import com.zenbet.zenbetapi.domain.Apostador;
import com.zenbet.zenbetapi.repository.ApostadorRepository;
import com.zenbet.zenbetapi.service.ApostadorService;
import org.springframework.stereotype.Service;

@Service
public class ApostadorServiceImpl implements ApostadorService {
    private final ApostadorRepository apostadorRepository;

    public ApostadorServiceImpl(ApostadorRepository apostadorRepository){
        this.apostadorRepository = apostadorRepository;
    }

    @Override
    public Apostador crearApostador(Apostador apostador) {
        return apostadorRepository.save(apostador);
    }
}
