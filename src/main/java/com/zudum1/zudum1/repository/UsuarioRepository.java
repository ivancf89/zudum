package com.zudum1.zudum1.repository;

import com.zudum1.zudum1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar un usuario por su email (para login y validaciones)
    Optional<Usuario> findByEmail(String email);
}
