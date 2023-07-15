package com.zenbet.zenbetapi.controller;


import com.zenbet.zenbetapi.domain.Partido;
import com.zenbet.zenbetapi.service.PartidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/partido")
@CrossOrigin(origins = "http://localhost:4200")
public class PartidoController {

    private final PartidoService partidoService;

    public PartidoController(PartidoService equipoService){
        this.partidoService = equipoService;
    }
    @GetMapping
    public ResponseEntity<List<Partido>> listarAllPartidos(){
        return new ResponseEntity<List<Partido>>(partidoService.listarAllPartidos(), HttpStatus.OK);
    }

}
