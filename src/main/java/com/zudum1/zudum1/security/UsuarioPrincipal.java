package com.zudum1.zudum1.security;

import com.zudum1.zudum1.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsuarioPrincipal implements UserDetails {

    private final Usuario usuario;

    public UsuarioPrincipal(Usuario usuario) {
        this.usuario = usuario;
    }

    // 🔑 ROLES (ROLE_USER / ROLE_ADMIN)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(usuario.getRol()));
    }

    // 🔐 Password (BCrypt)
    @Override
    public String getPassword() {
        return usuario.getPasswordHash();
    }

    // 👤 Username → usamos EMAIL
    @Override
    public String getUsername() {
        return usuario.getEmail();
    }

    // 🧠 Estados de la cuenta (dejamos todo activo)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // 🧩 Acceso al usuario original (útil más adelante)
    public Usuario getUsuario() {
        return usuario;
    }
}
