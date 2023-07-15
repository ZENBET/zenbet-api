package com.zenbet.zenbetapi.service.impl;

import com.zenbet.zenbetapi.domain.Partido;
import com.zenbet.zenbetapi.repository.PartidoRepository;
import com.zenbet.zenbetapi.service.PartidoService;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
