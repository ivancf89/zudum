package com.zudum1.zudum1.repository;

import com.zudum1.zudum1.model.ProgresoSerie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgresoSerieRepository extends JpaRepository<ProgresoSerie, Long> {

    List<ProgresoSerie> findByUsuarioId(Long usuarioId);

    Optional<ProgresoSerie> findBySerieIdAndUsuarioId(Long serieId, Long usuarioId);
}
