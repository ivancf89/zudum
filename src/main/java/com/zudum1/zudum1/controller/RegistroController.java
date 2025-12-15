package com.zudum1.zudum1.controller;

import com.zudum1.zudum1.model.Usuario;
import com.zudum1.zudum1.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistroController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistroController(UsuarioRepository usuarioRepository,
                              PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 🔓 Mostrar formulario de registro
    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro";
    }

    // 📝 Procesar registro
    @PostMapping("/registro")
    public String procesarRegistro(
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            Model model) {

        // ❌ Contraseñas no coinciden
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden");
            return "registro";
        }

        // ❌ Email duplicado
        if (usuarioRepository.existsByEmail(email)) {
            model.addAttribute("error", "El email ya está registrado");
            return "registro";
        }

        // ✅ Crear usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);

        // 🔐 BCrypt
        usuario.setPasswordHash(passwordEncoder.encode(password));

        // 👤 Rol automático
        usuario.setRol("ROLE_USER");

        usuarioRepository.save(usuario);

        // ✅ Mensaje post-registro (login)
        model.addAttribute("mensaje", "Registro exitoso. Inicia sesión.");

        return "login";
    }
}
