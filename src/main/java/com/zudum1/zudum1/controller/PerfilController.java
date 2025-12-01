package com.zudum1.zudum1.controller;

import com.zudum1.zudum1.model.ProgresoSerie;
import com.zudum1.zudum1.service.ProgresoSerieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

    private final ProgresoSerieService progresoSerieService;

    public PerfilController(ProgresoSerieService progresoSerieService) {
        this.progresoSerieService = progresoSerieService;
    }

    @GetMapping
    public String verPerfil(Model model) {
        Long usuarioId = 1L; // usuario fijo por ahora
        List<ProgresoSerie> progresos = progresoSerieService.listarPorUsuario(usuarioId);
        model.addAttribute("progresos", progresos);
        return "perfil";
    }
}
