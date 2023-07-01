package com.zenbet.zenbetapi.repository;

import com.zenbet.zenbetapi.domain.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Long> {

    @Query(value = "SELECT * FROM competencias WHERE UPPER(nombre_Competencia) like :nombre", nativeQuery = true)
    List<Competencia> findByNombre(String nombre);
}
