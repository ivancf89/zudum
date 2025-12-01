package com.zudum1.zudum1.controller;

import com.zudum1.zudum1.model.ProgresoSerie;
import com.zudum1.zudum1.model.Serie;
import com.zudum1.zudum1.service.EpisodioService;
import com.zudum1.zudum1.service.ProgresoSerieService;
import com.zudum1.zudum1.service.SerieService;
import com.zudum1.zudum1.service.TemporadaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CatalogoController {

    private final SerieService serieService;
    private final TemporadaService temporadaService;
    private final EpisodioService episodioService;
    private final ProgresoSerieService progresoSerieService;

    public CatalogoController(SerieService serieService,
                              TemporadaService temporadaService,
                              EpisodioService episodioService,
                              ProgresoSerieService progresoSerieService) {
        this.serieService = serieService;
        this.temporadaService = temporadaService;
        this.episodioService = episodioService;
        this.progresoSerieService = progresoSerieService;
    }

    @GetMapping("/")
    public String verCatalogo(Model model) {

        // 🔹 En el futuro usaremos el usuario logueado.
        Long usuarioId = 1L; // fijo por ahora

        // 🔹 Series para catálogo (posters y registro rápido)
        List<Serie> series = serieService.listarTodas();
        model.addAttribute("series", series);

        // 🔹 Progresos para mostrar "Mi lista de series"
        List<ProgresoSerie> progresos = progresoSerieService.listarPorUsuario(usuarioId);

        Map<Long, ProgresoSerie> progresoPorSerie = progresos.stream()
                .collect(Collectors.toMap(p -> p.getSerie().getId(), p -> p));

        model.addAttribute("progresoPorSerie", progresoPorSerie);

        // 🔹 Temporadas y episodios solo se usan para registro rápido
        model.addAttribute("temporadas", temporadaService.listarTodas());
        model.addAttribute("episodios", episodioService.listarTodas());

        // 📌 Vista principal = index.html
        return "index";
    }
}
