package com.avance.floreria.dto.request;

public record ProductoRequestDTO (
        String nombre,
        String descripcion,
        double precio,
        int stock,
        String imagenURL,
        Long categoriaID
){

}
