package com.zudum1.zudum1.config;

import com.zudum1.zudum1.model.Usuario;
import com.zudum1.zudum1.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initAdminUser(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {

            // 🔎 Verificamos si ya existe el admin
            if (!usuarioRepository.existsByEmail("admin@zudum.cl")) {

                Usuario admin = new Usuario();
                admin.setNombre("Administrador");
                admin.setEmail("admin@zudum.cl");

                // 🔐 BCrypt
                admin.setPasswordHash(
                        passwordEncoder.encode("admin123")
                );

                // 👑 Rol ADMIN
                admin.setRol("ROLE_ADMIN");

                usuarioRepository.save(admin);

                System.out.println("✅ Usuario ADMIN creado: admin@zudum.cl / admin123");
            }
        };
    }
}
