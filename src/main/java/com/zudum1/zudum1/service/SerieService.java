package com.zudum1.zudum1.service;

import com.zudum1.zudum1.model.Serie;

import java.util.List;

public interface SerieService {

    List<Serie> listarTodas();

    Serie guardar(Serie serie);

    Serie buscarPorId(Long id);

    void eliminar(Long id);
}