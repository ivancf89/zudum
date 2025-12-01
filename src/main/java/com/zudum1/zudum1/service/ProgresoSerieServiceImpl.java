package com.zudum1.zudum1.service;

import com.zudum1.zudum1.model.ProgresoSerie;
import com.zudum1.zudum1.model.Serie;
import com.zudum1.zudum1.model.Usuario;
import com.zudum1.zudum1.repository.ProgresoSerieRepository;
import com.zudum1.zudum1.repository.SerieRepository;
import com.zudum1.zudum1.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgresoSerieServiceImpl implements ProgresoSerieService {

    private final ProgresoSerieRepository progresoRepo;
    private final SerieRepository serieRepo;
    private final UsuarioRepository usuarioRepo;

    public ProgresoSerieServiceImpl(ProgresoSerieRepository progresoRepo,
                                    SerieRepository serieRepo,
                                    UsuarioRepository usuarioRepo) {
        this.progresoRepo = progresoRepo;
        this.serieRepo = serieRepo;
        this.usuarioRepo = usuarioRepo;
    }

    /**
     * Obtiene el progreso de una serie para un usuario.
     * Si no existe, crea un registro nuevo con estado VIENDO,
     * temporada 1, episodio 1.
     */
    @Override
    public ProgresoSerie obtenerProgreso(Long serieId, Long usuarioId) {
        // 1) Intentar recuperar si ya existe
        Optional<ProgresoSerie> existente =
                progresoRepo.findBySerieIdAndUsuarioId(serieId, usuarioId);

        if (existente.isPresent()) {
            return existente.get();
        }

        // 2) Si no existe, crear uno nuevo
        Serie serie = serieRepo.findById(serieId)
                .orElseThrow(() -> new RuntimeException("Serie no encontrada: " + serieId));

        Usuario usuario = usuarioRepo.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + usuarioId));

        ProgresoSerie nuevo = new ProgresoSerie();
        nuevo.setSerie(serie);
        nuevo.setUsuario(usuario);

        // Estado por defecto para un nuevo seguimiento
        nuevo.setEstado(ProgresoSerie.Estado.VIENDO);
        nuevo.setEpisodioActual(1);     // episodio 1
        nuevo.setTemporadaActual(1);    // temporada 1

        return progresoRepo.save(nuevo);
    }

    @Override
    public ProgresoSerie guardarProgreso(ProgresoSerie progreso) {
        return progresoRepo.save(progreso);
    }

    @Override
    public void actualizarEpisodio(Long serieId, Long usuarioId, int temporada, int episodio) {
        ProgresoSerie progreso = obtenerProgreso(serieId, usuarioId);
        progreso.setTemporadaActual(temporada);
        progreso.setEpisodioActual(episodio);
        progresoRepo.save(progreso);
    }

    @Override
    public void actualizarEstado(Long serieId, Long usuarioId, String estado) {
        ProgresoSerie progreso = obtenerProgreso(serieId, usuarioId);
        progreso.setEstado(ProgresoSerie.Estado.valueOf(estado));
        progresoRepo.save(progreso);
    }

    @Override
    public List<ProgresoSerie> listarPorUsuario(Long usuarioId) {
        return progresoRepo.findByUsuarioId(usuarioId);
    }
}
