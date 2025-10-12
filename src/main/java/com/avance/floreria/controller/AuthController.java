package com.avance.floreria.controller;

import com.avance.floreria.dto.request.EmailContraseñaRequestDTO;
import com.avance.floreria.dto.request.UsuarioRequestDTO;
import com.avance.floreria.dto.response.UsuarioResponseDTO;
import com.avance.floreria.service.AuthService;
import com.avance.floreria.service.impl.AuthServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody EmailContraseñaRequestDTO loginRequest,
                                                        HttpServletRequest request) {
        UsuarioResponseDTO usuario = authService.login(loginRequest);

        User userDetails = new User(usuario.email(), "",
                List.of(() -> "ROLE_" + usuario.rol()));

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        HttpSession session = request.getSession(true);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponseDTO> register(@RequestBody UsuarioRequestDTO registroRequest) {
        UsuarioResponseDTO usuario = authService.register(registroRequest);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioResponseDTO> me() {
        try {
            UsuarioResponseDTO usuario = authService.verUsuarioActual();
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Sesión cerrada correctamente");
    }
}