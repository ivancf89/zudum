package com.zudum1.zudum1.service;

import com.zudum1.zudum1.model.Usuario;

import java.util.Optional;

public interface UsuarioService {

    // Registrar nuevo usuario en la BD
    Usuario registrarUsuario(String nombre, String email, String passwordPlano);

    // Buscar usuario por email (útil para login)
    Optional<Usuario> buscarPorEmail(String email);

    // Validar login contra la BD
    boolean validarLogin(String email, String passwordPlano);
}
