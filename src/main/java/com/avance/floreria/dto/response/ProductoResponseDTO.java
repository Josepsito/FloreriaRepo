package com.avance.floreria.dto.response;

public record ProductoResponseDTO(
        String nombre,
        String descripcion,
        double precio,
        int stock,
        String imagenURL,
        long categoriaID
) {
}
