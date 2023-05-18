package com.zenbet.zenbetapi.service;

import com.zenbet.zenbetapi.domain.Competencia;

import java.util.List;
import java.util.Optional;

public interface CompetenciaService {

    Competencia crearCompetencia(Competencia competencia);
    List<Competencia> listarAllCompetencias();
    Competencia actualizarCompetencia(Competencia competencia);
    void eliminarCompetencia(Long idCompetencia);
    Optional<Competencia> buscarPorId(Long id);

}
