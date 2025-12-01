package com.zudum1.zudum1.service;

import com.zudum1.zudum1.model.Episodio;
import com.zudum1.zudum1.model.Temporada;
import com.zudum1.zudum1.repository.EpisodioRepository;
import com.zudum1.zudum1.repository.TemporadaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodioServiceImpl implements EpisodioService {

    private final EpisodioRepository episodioRepository;
    private final TemporadaRepository temporadaRepository;

    public EpisodioServiceImpl(EpisodioRepository episodioRepository,
                               TemporadaRepository temporadaRepository) {
        this.episodioRepository = episodioRepository;
        this.temporadaRepository = temporadaRepository;
    }

    // ✅ NUEVO: para el catálogo (home) que quiere todos los episodios
    @Override
    public List<Episodio> listarTodas() {
        return episodioRepository.findAll();
    }

    @Override
    public List<Episodio> listarPorTemporada(Long temporadaId) {
        Temporada temporada = temporadaRepository.findById(temporadaId)
                .orElseThrow(() -> new RuntimeException("Temporada no encontrada: " + temporadaId));
        return episodioRepository.findByTemporada(temporada);
    }

    @Override
    public Episodio guardar(Episodio episodio) {
        return episodioRepository.save(episodio);
    }

    @Override
    public Episodio buscarPorId(Long id) {
        return episodioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Episodio no encontrado: " + id));
    }

    @Override
    public void eliminar(Long id) {
        episodioRepository.deleteById(id);
    }
}
