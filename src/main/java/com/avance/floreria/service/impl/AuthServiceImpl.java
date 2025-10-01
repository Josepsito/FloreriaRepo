package com.avance.floreria.service.impl;

import com.avance.floreria.dto.request.EmailContraseñaRequestDTO;
import com.avance.floreria.dto.response.UsuarioResponseDTO;
import com.avance.floreria.entity.Usuario;
import com.avance.floreria.mapper.UsuarioMapper;
import com.avance.floreria.repository.UsuarioRepository;

import com.avance.floreria.service.AuthService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper usuarioMapper;

    public AuthServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioResponseDTO login(EmailContraseñaRequestDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(dto.contraseña(), usuario.getPasswordHash())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO verUsuarioActual() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() || auth instanceof AnonymousAuthenticationToken) {
            throw new RuntimeException("No hay usuario autenticado");
        }

        String email = auth.getName();
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return usuarioMapper.toDTO(usuario);
    }

}