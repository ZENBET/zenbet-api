package com.zenbet.zenbetapi.controller;

import com.zenbet.zenbetapi.domain.Competencia;
import com.zenbet.zenbetapi.repository.CompetenciaRepository;
import com.zenbet.zenbetapi.service.CompetenciaService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/competencia")
@CrossOrigin(origins = "http://localhost:4200")
public class CompetenciaController {

    private final CompetenciaService competenciaService;

    public CompetenciaController(CompetenciaService competenciaService){
        this.competenciaService = competenciaService;
    }

    @GetMapping
    public ResponseEntity<List<Competencia>> listarAllCompetencias(){
        return new ResponseEntity<List<Competencia>>(competenciaService.listarAllCompetencias(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Competencia> agregarCompetencia(@RequestBody Competencia competencia){
        return new ResponseEntity<Competencia>(competenciaService.crearCompetencia(competencia),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Competencia> actualizarCompetencia(@RequestBody Competencia competencia){
        Competencia updatedCompetencia = competenciaService.actualizarCompetencia(competencia);
        if (updatedCompetencia != null){
            return new ResponseEntity<Competencia>(updatedCompetencia, HttpStatus.OK);
        }else{
            return new ResponseEntity<Competencia>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCompetencia(@PathVariable("id") Long idCompetencia){
        competenciaService.eliminarCompetencia(idCompetencia);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competencia> buscarPorId(@PathVariable("id") Long id) {
        Optional<Competencia> competencia = competenciaService.buscarPorId(id);
        if (competencia.isPresent()) {
            return ResponseEntity.ok(competencia.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Competencia>> buscarPorNombre(@PathVariable("nombre") String nombre) {
        nombre = "%" + nombre.toUpperCase() + "%";
        List<Competencia> competencia = competenciaService.findByNombre(nombre);
        return ResponseEntity.ok(competencia);
    }

}



