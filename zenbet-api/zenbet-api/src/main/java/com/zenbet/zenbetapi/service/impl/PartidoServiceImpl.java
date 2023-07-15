package com.zenbet.zenbetapi.service.impl;

import com.zenbet.zenbetapi.domain.Equipo;
import com.zenbet.zenbetapi.domain.Partido;
import com.zenbet.zenbetapi.repository.PartidoRepository;
import com.zenbet.zenbetapi.service.PartidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoServiceImpl implements PartidoService {
    private final PartidoRepository partidoRepository;

    public PartidoServiceImpl(PartidoRepository partidoRepository){
        this.partidoRepository = partidoRepository;
    }

    @Override
    public List<Partido> listarAllPartidos() {
        return partidoRepository.findAll();
    }

    @Override
    public Partido crearPatido(Partido partido) {
        return partidoRepository.save(partido);
    }

    @Override
    public void eliminarPartido(Long idPartido) {
        partidoRepository.deleteById(idPartido);
    }

    @Override
    public Partido actualizarPartido(Partido partido) {
        Partido partidoToUpdate = partidoRepository.findById(partido.getIdPartido()).orElse(null);
        if (partidoToUpdate != null) {
            partidoToUpdate.setEquipo1(partido.getEquipo1());
            partidoToUpdate.setEquipo2(partido.getEquipo2());
            partidoToUpdate.setCompetencia(partido.getCompetencia());
            partidoToUpdate.setCuotaEquipo1(partido.getCuotaEquipo1());
            partidoToUpdate.setCuotaEquipo2(partido.getCuotaEquipo2());
            partidoToUpdate.setCuotaEmpate(partido.getCuotaEmpate());
            return partidoRepository.save(partidoToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public Optional<Partido> buscarPorId(Long idPartido) {
        return partidoRepository.findById(idPartido);
    }
}
