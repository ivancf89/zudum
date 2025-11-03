package com.zudum1.zudum1; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    // --- GESTIÓN DE USUARIO ---

    // 1. Mostrar Login (login.html)
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; 
    }

    // 2. Procesar Login (Simulación de autenticación)
    @PostMapping("/login")
    public String procesarLogin() {
        // Lógica simulada. Redirige al dashboard después de "iniciar sesión".
        return "redirect:/"; 
    }

    // 3. Mostrar Registro (registro.html)
    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro";
    }

    // 4. Procesar Registro (Simulación de guardado)
    @PostMapping("/registro")
    public String procesarRegistro() {
        // Lógica simulada. Redirige de vuelta al login tras "registrarse".
        return "redirect:/login"; 
    }

    // --- CRUD DEL CONTEXTO ZUDUM (Series/Progreso) ---

    // 5. Listado de Elementos (index.html) - El Dashboard
    @GetMapping("/")
    public String listarElementos() {
        return "index"; // Retorna index.html
    }

    // 6. Formulario para Crear (form-crear.html)
    @GetMapping("/nuevo")
    public String mostrarFormularioCrear() {
        return "form-crear"; // Retorna form-crear.html
    }

    // 7. Simular Guardado
    @PostMapping("/guardar")
    public String guardarElemento() {
        return "redirect:/"; // Vuelve al listado
    }

    // 8. Formulario para Editar (form-editar.html)
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id) {
        return "form-editar"; // Retorna form-editar.html
    }

    // 9. Simular Actualización
    @PostMapping("/actualizar/{id}")
    public String actualizarElemento(@PathVariable("id") Long id) {
        return "redirect:/"; // Vuelve al listado
    }

    // 10. Simular Eliminación
    @GetMapping("/eliminar/{id}")
    public String eliminarElemento(@PathVariable("id") Long id) {
        return "redirect:/"; // Vuelve al listado
    }
}