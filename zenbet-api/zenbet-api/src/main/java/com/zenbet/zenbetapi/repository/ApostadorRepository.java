package com.zenbet.zenbetapi.repository;

import com.zenbet.zenbetapi.domain.Apostador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ApostadorRepository extends JpaRepository<Apostador, Long> {
    Apostador findByDniAndContrasena(@Param("dni") Long dni, @Param("contrasena") String contrasena);

    //borrar desde aca

}
