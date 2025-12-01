package com.zudum1.zudum1.service;

import com.zudum1.zudum1.model.Temporada;
import com.zudum1.zudum1.repository.TemporadaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemporadaServiceImpl implements TemporadaService {

    private final TemporadaRepository temporadaRepository;

    public TemporadaServiceImpl(TemporadaRepository temporadaRepository) {
        this.temporadaRepository = temporadaRepository;
    }

    @Override
    public List<Temporada> listarTodas() {
        return temporadaRepository.findAll();
    }

    @Override
    public List<Temporada> listarPorSerie(Long serieId) {
        return temporadaRepository.findBySerieId(serieId);
    }

    @Override
    public Temporada guardar(Temporada temporada) {
        return temporadaRepository.save(temporada);
    }

    @Override
    public Temporada buscarPorId(Long id) {
        return temporadaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        temporadaRepository.deleteById(id);
    }
}

