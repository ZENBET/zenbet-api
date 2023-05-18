package com.zenbet.zenbetapi.service.impl;

import com.zenbet.zenbetapi.domain.Equipo;
import com.zenbet.zenbetapi.repository.EquipoRepository;
import com.zenbet.zenbetapi.service.EquipoService;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class EquipoServiceImpl implements EquipoService {
    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public List<Equipo> listarAllEquipos() {
        return equipoRepository.findAll();
    }

    @Override
    public Equipo crearEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }
}
