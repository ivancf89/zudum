package com.zudum1.zudum1.service;

import com.zudum1.zudum1.model.ProgresoSerie;

import java.util.List;

public interface ProgresoSerieService {

    ProgresoSerie obtenerProgreso(Long serieId, Long usuarioId);

    ProgresoSerie guardarProgreso(ProgresoSerie progreso);

    void actualizarEpisodio(Long serieId, Long usuarioId, int temporada, int episodio);

    void actualizarEstado(Long serieId, Long usuarioId, String estado);

    // para mostrar en el perfil
    List<ProgresoSerie> listarPorUsuario(Long usuarioId);
}