package com.zudum1.zudum1.service;

import com.zudum1.zudum1.model.Serie;
import com.zudum1.zudum1.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements SerieService {

    private final SerieRepository serieRepository;

    public SerieServiceImpl(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<Serie> listarTodas() {
        return serieRepository.findAll();
    }

    @Override
    public Serie guardar(Serie serie) {
        return serieRepository.save(serie);
    }

    @Override
    public Serie buscarPorId(Long id) {
        return serieRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        serieRepository.deleteById(id);
    }
}