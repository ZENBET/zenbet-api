package com.zenbet.zenbetapi.controller;

import com.zenbet.zenbetapi.domain.Competencia;
import com.zenbet.zenbetapi.domain.Equipo;
import com.zenbet.zenbetapi.service.EquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/equipo")
@CrossOrigin(origins = "http://localhost:4200")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable("id") Long idEquipo){
        equipoService.eliminarEquipo(idEquipo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> buscarPorId(@PathVariable("id") Long idEquipo) {
        Optional<Equipo> equipo = equipoService.buscarPorId(idEquipo);
        if (equipo.isPresent()) {
            return ResponseEntity.ok(equipo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Equipo>> buscarPorNombre(@PathVariable("nombre") String nombre) {
        nombre = "%" + nombre.toUpperCase() + "%";
        List<Equipo> equipo = equipoService.findByNombre(nombre);
        return ResponseEntity.ok(equipo);
    }

}
