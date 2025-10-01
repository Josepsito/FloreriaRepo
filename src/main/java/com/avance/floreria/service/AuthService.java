package com.avance.floreria.service;

import com.avance.floreria.dto.request.EmailContraseñaRequestDTO;
import com.avance.floreria.dto.response.UsuarioResponseDTO;

public interface AuthService {
    UsuarioResponseDTO login(EmailContraseñaRequestDTO dto);

    UsuarioResponseDTO verUsuarioActual();
}
