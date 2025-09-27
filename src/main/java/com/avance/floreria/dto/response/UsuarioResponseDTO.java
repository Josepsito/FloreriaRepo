package com.avance.floreria.dto.response;

public record UsuarioResponseDTO(
        String nombre,
        String email,
        String telefono,
        String direccion
) {
}