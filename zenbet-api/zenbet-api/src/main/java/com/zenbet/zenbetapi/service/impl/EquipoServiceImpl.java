package com.zenbet.zenbetapi.service.impl;

import com.zenbet.zenbetapi.domain.Equipo;
import com.zenbet.zenbetapi.repository.EquipoRepository;
import com.zenbet.zenbetapi.service.EquipoService;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class EquipoServiceImpl implements EquipoService {
    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository){
        this.equipoRepository = equipoRepository;
    }

    @Override
    public List<Equipo> listarAllEquipos() { return equipoRepository.findAll(); }

    @Override
    public Equipo crearEquipo(Equipo equipo) { return equipoRepository.save(equipo);}

    @Override
    public Equipo actualizarEquipo(Equipo equipo) {
        Equipo equipoToUpdate = equipoRepository.findById(equipo.getIdEquipo()).orElse(null);
        if (equipoToUpdate != null) {
            equipoToUpdate.setNombreEquipo(equipo.getNombreEquipo());
            equipoToUpdate.setUbicacionEquipo(equipo.getUbicacionEquipo());
            return equipoRepository.save(equipoToUpdate);
        } else {
            return null;
        }
    }
    @Override
    public void eliminarEquipo(Long idEquipo){ equipoRepository.deleteById(idEquipo);}

}
