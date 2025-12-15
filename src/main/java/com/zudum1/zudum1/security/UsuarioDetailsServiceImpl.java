package com.zudum1.zudum1.security;

import com.zudum1.zudum1.model.Usuario;
import com.zudum1.zudum1.repository.UsuarioRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Este método lo llama Spring Security automáticamente
     * cuando alguien intenta iniciar sesión.
     */
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // 🔎 Buscamos al usuario por email (o nombre, según tu login)
        Usuario usuario = usuarioRepository.findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Usuario no encontrado con email: " + username
                        )
                );

        // 🔐 Convertimos Usuario → UserDetails
        return new UsuarioPrincipal(usuario);
    }
}
