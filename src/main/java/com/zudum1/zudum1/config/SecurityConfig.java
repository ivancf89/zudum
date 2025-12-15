package com.zudum1.zudum1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // 🔐 Password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 🔐 Authentication Manager
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    // 🔐 Configuración de seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Necesario para H2
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))

            .authorizeHttpRequests(auth -> auth

                // 🔓 RECURSOS ESTÁTICOS (CLAVE)
                .requestMatchers(
                        "/css/**",
                        "/js/**",
                        "/img/**",
                        "/images/**"
                ).permitAll()

                // 🔓 Rutas públicas
                .requestMatchers(
                        "/",
                        "/login",
                        "/registro",
                        "/h2-console/**"
                ).permitAll()

                // 👤 USER y ADMIN
                .requestMatchers("/series/**").hasAnyRole("USER", "ADMIN")

                // 👑 ADMIN
                .requestMatchers("/admin/**").hasRole("ADMIN")

                // 🔒 Todo lo demás
                .anyRequest().authenticated()
            )

            // 🔐 Login
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error=true")
                .permitAll()
            )

            // 🔓 Logout
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            );

        return http.build();
    }
}
