package com.zudum1.zudum1.controller;

import com.zudum1.zudum1.model.Episodio;
import com.zudum1.zudum1.model.ProgresoSerie;
import com.zudum1.zudum1.model.Serie;
import com.zudum1.zudum1.model.Temporada;
import com.zudum1.zudum1.model.Usuario;
import com.zudum1.zudum1.repository.EpisodioRepository;
import com.zudum1.zudum1.repository.ProgresoSerieRepository;
import com.zudum1.zudum1.repository.SerieRepository;
import com.zudum1.zudum1.repository.TemporadaRepository;
import com.zudum1.zudum1.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/progreso")
public class ProgresoSerieController {

    private final SerieRepository serieRepository;
    private final TemporadaRepository temporadaRepository;
    private final EpisodioRepository episodioRepository;
    private final ProgresoSerieRepository progresoSerieRepository;
    private final UsuarioRepository usuarioRepository;

    public ProgresoSerieController(SerieRepository serieRepository,
                                   TemporadaRepository temporadaRepository,
                                   EpisodioRepository episodioRepository,
                                   ProgresoSerieRepository progresoSerieRepository,
                                   UsuarioRepository usuarioRepository) {
        this.serieRepository = serieRepository;
        this.temporadaRepository = temporadaRepository;
        this.episodioRepository = episodioRepository;
        this.progresoSerieRepository = progresoSerieRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // 🔹 Formulario manual (Vista independiente, opcional)
    @GetMapping("/nuevo")
    public String mostrarFormularioProgreso(Model model) {
        model.addAttribute("series", serieRepository.findAll());
        return "progreso-form";
    }

    // 🔹 Devuelve temporadas de una serie (JSON para combos dependientes)
    @GetMapping("/temporadas")
    @ResponseBody
    public List<Temporada> obtenerTemporadasPorSerie(@RequestParam("serieId") Long serieId) {
        return temporadaRepository.findBySerieId(serieId);
    }

    // 🔹 Devuelve episodios de una temporada (JSON para combos dependientes)
    @GetMapping("/episodios")
    @ResponseBody
    public List<Episodio> obtenerEpisodiosPorTemporada(@RequestParam("temporadaId") Long temporadaId) {
        return episodioRepository.findByTemporadaId(temporadaId);
    }

    // 🔹 Guardar el progreso desde / (registro rápido)
    @PostMapping("/guardar")
    public String guardarProgreso(
            @RequestParam("serieId") Long serieId,
            @RequestParam("temporadaId") Long temporadaId,
            @RequestParam("episodioId") Long episodioId,
            @RequestParam("estado") String estadoValor,
            Model model
    ) {
        // Usuario fijo (para la evaluación)
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            model.addAttribute("error", "Debe registrar un usuario antes de guardar el progreso.");
            model.addAttribute("series", serieRepository.findAll());
            return "progreso-form";
        }

        Usuario usuario = usuarios.get(0);

        Serie serie = serieRepository.findById(serieId)
                .orElseThrow(() -> new IllegalArgumentException("Serie no encontrada"));

        Temporada temporada = temporadaRepository.findById(temporadaId)
                .orElseThrow(() -> new IllegalArgumentException("Temporada no encontrada"));

        Episodio episodio = episodioRepository.findById(episodioId)
                .orElseThrow(() -> new IllegalArgumentException("Episodio no encontrado"));

        ProgresoSerie progreso = new ProgresoSerie();
        progreso.setUsuario(usuario);
        progreso.setSerie(serie);
        progreso.setTemporadaActual(temporada.getNumeroTemporada());
        progreso.setEpisodioActual(episodio.getNumeroEpisodio());
        progreso.setEstado(ProgresoSerie.Estado.valueOf(estadoValor));

        progresoSerieRepository.save(progreso);
        return "redirect:/perfil";
    }

    // 🔹 Actualizar SOLO el ESTADO desde el perfil
    @PostMapping("/estado")
    public String actualizarEstado(
            @RequestParam("progresoId") Long progresoId,
            @RequestParam("estado") String estadoValor
    ) {
        ProgresoSerie progreso = progresoSerieRepository.findById(progresoId)
                .orElseThrow(() -> new IllegalArgumentException("Progreso no encontrado"));

        progreso.setEstado(ProgresoSerie.Estado.valueOf(estadoValor));
        progresoSerieRepository.save(progreso);

        return "redirect:/perfil";
    }

    // 🔹 Eliminar un progreso desde el perfil
    @GetMapping("/eliminar/{id}")
    public String eliminarProgreso(@PathVariable("id") Long id) {
        progresoSerieRepository.deleteById(id);
        return "redirect:/perfil";
    }
}
