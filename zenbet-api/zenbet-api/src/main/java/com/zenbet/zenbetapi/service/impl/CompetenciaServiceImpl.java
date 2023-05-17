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

    @Override
    public Competencia crearCompetencia(Competencia competencia){
        return competenciaRepository.save(competencia);
    }

    @Override
    public Competencia actualizarCompetencia(Competencia competencia){
        Competencia competenciaToUpdate = competenciaRepository.findById(competencia.getIdCompetencia()).orElse(null);
        if(competenciaToUpdate != null){
            competenciaToUpdate.setNombreCompetencia(competencia.getNombreCompetencia());
            competenciaToUpdate.setFechaInicio(competencia.getFechaInicio());
            competenciaToUpdate.setFechaFin(competencia.getFechaFin());
            return competenciaRepository.save(competenciaToUpdate);
        }else {
            return null;
        }
    }

}
