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

    public EquipoController(EquipoService equipoService){
        this.equipoService = equipoService;
    }

    @GetMapping
    public  ResponseEntity<List<Equipo>> listarAllEquipos(){
        return new ResponseEntity<List<Equipo>>(equipoService.listarAllEquipos(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Equipo> agregarEquipo(@RequestBody Equipo equipo){
        return  new ResponseEntity<Equipo>(equipoService.crearEquipo(equipo),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Equipo> actualizarEquipo(@RequestBody Equipo equipo){
        Equipo updatedEquipo = equipoService.actualizarEquipo(equipo);
        if (updatedEquipo != null){
            return new ResponseEntity<Equipo>(updatedEquipo, HttpStatus.OK);
        }else {
            return new ResponseEntity<Equipo>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminarEquipo(@RequestBody Equipo equipo){
        equipoService.eliminarEquipo(equipo.getIdEquipo());
        return ResponseEntity.ok().build();
    }

}
