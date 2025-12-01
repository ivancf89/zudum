package com.zudum1.zudum1.repository;

import com.zudum1.zudum1.model.Temporada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemporadaRepository extends JpaRepository<Temporada, Long> {

    // 🔹 Todas las temporadas de una serie
    List<Temporada> findBySerieId(Long serieId);
}
