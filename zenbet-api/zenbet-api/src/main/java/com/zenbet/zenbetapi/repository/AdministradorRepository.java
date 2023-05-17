package com.zenbet.zenbetapi.repository;

import com.zenbet.zenbetapi.domain.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}
