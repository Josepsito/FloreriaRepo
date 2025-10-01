package com.avance.floreria;

import com.avance.floreria.entity.Usuario;
import com.avance.floreria.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FloreriaRepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FloreriaRepoApplication.class, args);
    }


    @Bean
    public CommandLineRunner initAdmin(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return crearAdmin -> {
            String adminEmail = "admin@floreria.com";

            if (usuarioRepository.findByEmail(adminEmail).isEmpty()) {
                Usuario admin = new Usuario();
                admin.setNombre("Administrador");
                admin.setEmail(adminEmail);
                admin.setPasswordHash(passwordEncoder.encode("admin123"));
                admin.setRol(Usuario.Rol.ADMIN);

                usuarioRepository.save(admin);
                System.out.println("✅ Usuario ADMIN creado: " + adminEmail + " / admin123");
            } else {
                System.out.println("ℹ️ Usuario ADMIN ya existe.");
            }
        };
    }
}