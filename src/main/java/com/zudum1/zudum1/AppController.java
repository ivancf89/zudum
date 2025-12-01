package com.zudum1.zudum1;

import com.zudum1.zudum1.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    private final UsuarioService usuarioService;

    // Inyección del servicio de usuarios
    public AppController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // --- GESTIÓN DE USUARIO ---

    // 1. Mostrar Login (login.html)
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    // 2. Procesar Login (VALIDANDO contra la BD)
    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model
    ) {
        boolean valido = usuarioService.validarLogin(email, password);

        if (valido) {
            // El home real ahora es "/", manejado por CatalogoController
            return "redirect:/";
        } else {
            model.addAttribute("error", "Correo o contraseña incorrectos.");
            return "login";
        }
    }

    // 3. Mostrar Registro (registro.html)
    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro";
    }

    // 4. Procesar Registro (GUARDANDO en la BD)
    @PostMapping("/registro")
    public String procesarRegistro(
            @RequestParam("nombre") String nombre,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model
    ) {
        try {
            usuarioService.registrarUsuario(nombre, email, password);
            // Después de registrar, volvemos al login con un mensaje
            model.addAttribute("mensaje", "Usuario registrado correctamente. Ahora puedes iniciar sesión.");
            return "login";
        } catch (IllegalArgumentException e) {
            // Por ejemplo: correo ya registrado
            model.addAttribute("error", e.getMessage());
            return "registro";
        }
    }

    // --- CRUD DEL CONTEXTO ZUDUM (Series/Progreso) ---

    // 5. Dashboard antiguo (index.html) - ahora en /dashboard
    //   ⚠️ Antes era @GetMapping("/")
    @GetMapping("/dashboard")
    public String listarElementos() {
        return "index"; // sigue retornando index.html, pero ya no en "/"
    }

    // 6. Formulario para Crear (form-crear.html)
    @GetMapping("/nuevo")
    public String mostrarFormularioCrear() {
        return "form-crear"; // Retorna form-crear.html
    }

    // 7. Simular Guardado
    @PostMapping("/guardar")
    public String guardarElemento() {
        return "redirect:/dashboard"; // Vuelve al dashboard antiguo
    }

    // 8. Formulario para Editar (form-editar.html)
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id) {
        return "form-editar"; // Retorna form-editar.html
    }

    // 9. Simular Actualización
    @PostMapping("/actualizar/{id}")
    public String actualizarElemento(@PathVariable("id") Long id) {
        return "redirect:/dashboard"; // Vuelve al dashboard
    }

    // 10. Simular Eliminación
    @GetMapping("/eliminar/{id}")
    public String eliminarElemento(@PathVariable("id") Long id) {
        return "redirect:/dashboard"; // Vuelve al dashboard
    }
}
