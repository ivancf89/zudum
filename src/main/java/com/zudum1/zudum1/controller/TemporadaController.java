package com.zudum1.zudum1.controller;

import com.zudum1.zudum1.model.Serie;
import com.zudum1.zudum1.model.Temporada;
import com.zudum1.zudum1.service.SerieService;
import com.zudum1.zudum1.service.TemporadaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/temporadas")
public class TemporadaController {

    private final TemporadaService temporadaService;
    private final SerieService serieService;

    public TemporadaController(TemporadaService temporadaService, SerieService serieService) {
        this.temporadaService = temporadaService;
        this.serieService = serieService;
    }

    // Listar temporadas de una serie
    @GetMapping("/serie/{serieId}")
    public String listarPorSerie(@PathVariable Long serieId, Model model) {
        Serie serie = serieService.buscarPorId(serieId);
        List<Temporada> temporadas = temporadaService.listarPorSerie(serieId);

        model.addAttribute("serie", serie);
        model.addAttribute("temporadas", temporadas);
        model.addAttribute("temporada", new Temporada());

        return "temporadas";
    }

    // Guardar nueva temporada de una serie
    @PostMapping("/serie/{serieId}/guardar")
    public String guardar(@PathVariable Long serieId,
                          @ModelAttribute Temporada temporada) {

        Serie serie = serieService.buscarPorId(serieId);
        temporada.setSerie(serie);
        temporadaService.guardar(temporada);

        return "redirect:/temporadas/serie/" + serieId;
    }

    // Eliminar temporada
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        Temporada temporada = temporadaService.buscarPorId(id);
        Long serieId = temporada.getSerie().getId();

        temporadaService.eliminar(id);
        return "redirect:/temporadas/serie/" + serieId;
    }
}

