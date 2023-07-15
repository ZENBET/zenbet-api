package com.zenbet.zenbetapi.controller;


import com.zenbet.zenbetapi.domain.Partido;
import com.zenbet.zenbetapi.service.PartidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //Crear partido
    @PostMapping
    public ResponseEntity<Partido> agregarPartido(@RequestBody Partido partido){
        return  new ResponseEntity<Partido>(partidoService.crearPatido(partido), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPartido(@PathVariable("id") Long idPartido){
        partidoService.eliminarPartido(idPartido);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Partido> actualizarPartido(@RequestBody Partido partido){
        Partido updatedPartido = partidoService.actualizarPartido(partido);
        if (updatedPartido != null){
            return new ResponseEntity<Partido>(updatedPartido, HttpStatus.OK);
        }else {
            return new ResponseEntity<Partido>(HttpStatus.NOT_FOUND);
        }
    }
}
