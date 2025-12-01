package com.zudum1.zudum1.controller;

import com.zudum1.zudum1.model.Episodio;
import com.zudum1.zudum1.model.Temporada;
import com.zudum1.zudum1.service.EpisodioService;
import com.zudum1.zudum1.service.TemporadaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/episodios")
public class EpisodioController {

    private final EpisodioService episodioService;
    private final TemporadaService temporadaService;

    public EpisodioController(EpisodioService episodioService,
                              TemporadaService temporadaService) {
        this.episodioService = episodioService;
        this.temporadaService = temporadaService;
    }

    // 🔹 Listar episodios de una temporada
    @GetMapping("/temporada/{temporadaId}")
    public String listarPorTemporada(@PathVariable Long temporadaId, Model model) {

        Temporada temporada = temporadaService.buscarPorId(temporadaId);
        if (temporada == null) {
            return "redirect:/series";
        }

        List<Episodio> episodios = episodioService.listarPorTemporada(temporadaId);

        model.addAttribute("temporada", temporada);
        model.addAttribute("serie", temporada.getSerie());
        model.addAttribute("episodios", episodios);
        model.addAttribute("episodio", new Episodio()); // para el formulario

        return "episodios";
    }

    // 🔹 Guardar nuevo episodio
    @PostMapping("/temporada/{temporadaId}/guardar")
    public String guardar(@PathVariable Long temporadaId,
                          @ModelAttribute Episodio episodio) {

        Temporada temporada = temporadaService.buscarPorId(temporadaId);
        if (temporada == null) {
            return "redirect:/series";
        }

        episodio.setTemporada(temporada);
        episodioService.guardar(episodio);

        return "redirect:/episodios/temporada/" + temporadaId;
    }

    // 🔹 Eliminar episodio
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        Episodio episodio = episodioService.buscarPorId(id);
        if (episodio != null) {
            Long temporadaId = episodio.getTemporada().getId();
            episodioService.eliminar(id);
            return "redirect:/episodios/temporada/" + temporadaId;
        }

        return "redirect:/series";
    }
}
