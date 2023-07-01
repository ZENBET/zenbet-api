package com.zenbet.zenbetapi.service.impl;

import com.zenbet.zenbetapi.domain.Competencia;
import com.zenbet.zenbetapi.repository.CompetenciaRepository;
import com.zenbet.zenbetapi.service.CompetenciaService;
import lombok.Lombok;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void eliminarCompetencia(Long idCompetencia){
        competenciaRepository.deleteById(idCompetencia);
    }

    @Override
    public Optional<Competencia> buscarPorId(Long id) {
        return competenciaRepository.findById(id);
    }
    @Override
    public List<Competencia> findByNombre(String nombre) {
        return competenciaRepository.findByNombre(nombre);
    }
}
