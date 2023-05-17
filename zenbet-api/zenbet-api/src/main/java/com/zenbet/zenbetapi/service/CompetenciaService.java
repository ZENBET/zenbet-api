package com.zenbet.zenbetapi.service;

import com.zenbet.zenbetapi.domain.Competencia;

import java.util.List;

public interface CompetenciaService {

    Competencia crearCompetencia(Competencia competencia);
    List<Competencia> listarAllCompetencias();
    Competencia actualizarCompetencia(Competencia competencia);

}
