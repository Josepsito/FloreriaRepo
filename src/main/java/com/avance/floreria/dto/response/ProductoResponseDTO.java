package com.avance.floreria.dto.response;

public record ProductoResponseDTO(
        long id,
        String nombre,
        String descripcion,
        java.math.BigDecimal precio,
        int stock,
        String imagenURL,
        long categoriaID
) {
}
