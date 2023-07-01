package com.zenbet.zenbetapi.repository;

import com.zenbet.zenbetapi.domain.Competencia;
import com.zenbet.zenbetapi.domain.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    @Query(value = "SELECT * FROM equipos WHERE UPPER(nombre) like :nombre", nativeQuery = true)
    List<Equipo> findByNombre(String nombre);
}