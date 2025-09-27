package com.avance.floreria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 🔹 deshabilita CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 🔹 permite todas las requests
                )
                .formLogin(login -> login.disable()) // 🔹 deshabilita login por formulario
                .httpBasic(basic -> basic.disable()); // 🔹 deshabilita basic auth

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}