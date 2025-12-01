package com.zudum1.zudum1.service;

import com.zudum1.zudum1.model.Episodio;

import java.util.List;

public interface EpisodioService {

    // 👉 NUEVO: listar todos los episodios
    List<Episodio> listarTodas();

    // 👉 ya lo teníamos
    List<Episodio> listarPorTemporada(Long temporadaId);

    Episodio guardar(Episodio episodio);

    Episodio buscarPorId(Long id);

    void eliminar(Long id);
}
