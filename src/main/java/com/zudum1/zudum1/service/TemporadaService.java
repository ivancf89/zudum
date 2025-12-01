package com.zudum1.zudum1.service;

import com.zudum1.zudum1.model.Temporada;
import java.util.List;

public interface TemporadaService {

    List<Temporada> listarTodas();

    List<Temporada> listarPorSerie(Long serieId);  

    Temporada guardar(Temporada temporada);

    Temporada buscarPorId(Long id);

    void eliminar(Long id);
}
