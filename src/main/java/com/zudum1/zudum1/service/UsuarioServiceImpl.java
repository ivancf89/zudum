package com.zudum1.zudum1.service;

import com.zudum1.zudum1.model.Usuario;
import com.zudum1.zudum1.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Inyección por constructor (Spring se encarga)
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario registrarUsuario(String nombre, String email, String passwordPlano) {
        // ¿Ya existe un usuario con ese email?
        Optional<Usuario> existente = usuarioRepository.findByEmail(email);
        if (existente.isPresent()) {
            // Lanzamos una excepción simple para manejarla en el controlador
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setEmail(email);
        // Por ahora guardamos el password en texto plano en el campo passwordHash
        u.setPasswordHash(passwordPlano);

        return usuarioRepository.save(u);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public boolean validarLogin(String email, String passwordPlano) {
        return usuarioRepository.findByEmail(email)
                .map(u -> u.getPasswordHash() != null
                        && u.getPasswordHash().equals(passwordPlano))
                .orElse(false);
    }
}
