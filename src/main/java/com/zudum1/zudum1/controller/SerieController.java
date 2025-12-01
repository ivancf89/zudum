package com.zudum1.zudum1.controller;

import com.zudum1.zudum1.model.Serie;
import com.zudum1.zudum1.service.SerieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/series")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    // GET /series -> mostrar listado + formulario
    @GetMapping
    public String listarSeries(Model model) {
        List<Serie> series = serieService.listarTodas();
        model.addAttribute("series", series);

        // 🔴 IMPORTANTE: el nombre "serie" DEBE coincidir con th:object="${serie}" en series.html
        model.addAttribute("serie", new Serie());

        return "series"; // templates/series.html
    }

    // POST /series -> guardar serie
    @PostMapping
    public String guardarSerie(@ModelAttribute("serie") Serie serie) {
        serieService.guardar(serie);
        return "redirect:/series";
    }

    // GET /series/eliminar/{id} -> eliminar una serie
    @GetMapping("/eliminar/{id}")
    public String eliminarSerie(@PathVariable Long id) {
        serieService.eliminar(id);
        return "redirect:/series";
    }
}
