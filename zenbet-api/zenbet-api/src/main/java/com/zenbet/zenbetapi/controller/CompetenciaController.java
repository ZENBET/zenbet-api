package com.zenbet.zenbetapi.controller;

import com.zenbet.zenbetapi.domain.Competencia;
import com.zenbet.zenbetapi.service.CompetenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competencia")
public class CompetenciaController {

    private final CompetenciaService competenciaService;

    public CompetenciaController(CompetenciaService competenciaService){
        this.competenciaService = competenciaService;
    }

    @PostMapping
    public ResponseEntity<Competencia> addCompetencia(@RequestBody Competencia competencia){
        return new ResponseEntity<Competencia>(competenciaService.createCompetencia(competencia),HttpStatus.CREATED);
    }
}
