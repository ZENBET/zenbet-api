package com.zenbet.zenbetapi.controller;

import com.zenbet.zenbetapi.domain.Apostador;
import com.zenbet.zenbetapi.repository.AdministradorRepository;
import com.zenbet.zenbetapi.repository.ApostadorRepository;
import com.zenbet.zenbetapi.service.ApostadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/apostador")
@CrossOrigin(origins = "http://localhost:4200")
public class ApostadorController {
    private final ApostadorService apostadorService;
    @Autowired
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

    @PutMapping
    public ResponseEntity<Apostador> actualizarApostador( @RequestBody Apostador apostador){
        Apostador updatedApos= apostadorService.actualizarApostador(apostador);
        if(updatedApos != null) {
            return new ResponseEntity<Apostador>(updatedApos, HttpStatus.OK);
        } else {
            return new ResponseEntity<Apostador>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> eliminarApostador(@PathVariable("dni") String dni) {
        apostadorService.eliminarApostador(Long.parseLong(dni));
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{dni}")
    public ResponseEntity<Apostador> buscarPorDni(@PathVariable("dni") Long dni) {
        Optional<Apostador> apostador = apostadorService.buscarPorDni(dni);
        if (apostador.isPresent()) {
            return ResponseEntity.ok(apostador.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Apostador> login(@RequestBody Apostador apostador) {
        Long dni = apostador.getDni();
        String contrasena = apostador.getContrasena();

        Apostador authenticatedApostador = apostadorService.findByDniAndContrasena(dni, contrasena);

        if (authenticatedApostador != null) {
            // El inicio de sesión fue exitoso
            return ResponseEntity.ok(authenticatedApostador);
        } else {
            // Las credenciales son incorrectas o el usuario no existe
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    //
    @PutMapping("/{dni}/incrementar-saldo")
    public Apostador incrementarSaldo(@PathVariable Long dni, @RequestBody Map<String, Float> requestBody) {
        Float cantidad = requestBody.get("cantidad");
        return apostadorService.incrementarSaldo(dni, cantidad);
    }



}
