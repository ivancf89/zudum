package com.zudum1.zudum1.repository;

import com.zudum1.zudum1.model.Episodio;
import com.zudum1.zudum1.model.Temporada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodioRepository extends JpaRepository<Episodio, Long> {

    // Para EpisodioServiceImpl (ya lo usabas)
    List<Episodio> findByTemporada(Temporada temporada);

    // Para los combos dependientes (por ID)
    List<Episodio> findByTemporadaId(Long temporadaId);
}
