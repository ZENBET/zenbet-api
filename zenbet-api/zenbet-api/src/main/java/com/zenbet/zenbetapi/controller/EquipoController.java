package com.zenbet.zenbetapi.controller;

import com.zenbet.zenbetapi.domain.Equipo;
import com.zenbet.zenbetapi.service.EquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/equipo")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public ResponseEntity<List<Equipo>> listarAllEquipos() {
        return new ResponseEntity<List<Equipo>>(equipoService.listarAllEquipos(), HttpStatus.OK);
    }
}