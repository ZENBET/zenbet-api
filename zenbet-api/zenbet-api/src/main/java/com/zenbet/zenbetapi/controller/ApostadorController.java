package com.zenbet.zenbetapi.controller;

import com.zenbet.zenbetapi.domain.Apostador;
import com.zenbet.zenbetapi.service.ApostadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/apostador")
public class ApostadorController {
    private final ApostadorService apostadorService;
    public ApostadorController(ApostadorService apostadorService){
        this.apostadorService = apostadorService;
    }

    @PostMapping
    public ResponseEntity<Apostador> crearApostador(@RequestBody Apostador apostador){
        Apostador apd = apostadorService.crearApostador(apostador);
        if(!apd.getDni().toString().isEmpty())
            return new ResponseEntity<Apostador>(apd,HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<List<Apostador>> listarApostadores(){
        return new ResponseEntity<List<Apostador>>(apostadorService.listarApostadores(), HttpStatus.OK);
    }
}
