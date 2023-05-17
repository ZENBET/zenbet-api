package com.zenbet.zenbetapi.controller;

import com.zenbet.zenbetapi.domain.Administrador;
import com.zenbet.zenbetapi.service.AdministradorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/administrador")
public class AdministradorController {
    private final AdministradorService administradorService;
    public AdministradorController(AdministradorService administradorService){
        this.administradorService = administradorService;
    }

    @PostMapping
    public ResponseEntity<Administrador> addAdministrador(@RequestBody Administrador administrador){
        Administrador adm = administradorService.crearAdministrador(administrador);
        if(!adm.getDni().toString().isEmpty())
            return new ResponseEntity<Administrador>(adm, HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
