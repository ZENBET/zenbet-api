package com.zenbet.zenbetapi.service.impl;

import com.zenbet.zenbetapi.domain.Competencia;
import com.zenbet.zenbetapi.repository.CompetenciaRepository;
import com.zenbet.zenbetapi.service.CompetenciaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenciaServiceImpl implements CompetenciaService {

    private final CompetenciaRepository competenciaRepository;

    public CompetenciaServiceImpl(CompetenciaRepository competenciaRepository){
        this.competenciaRepository = competenciaRepository;
    }

    @Override
    public List<Competencia> listarAllCompetencias() {
        return competenciaRepository.findAll();
    }

}
