package com.avance.floreria.dto.request;

public record UsuarioRequestDTO (
        String nombre,
        String password,
        String email,
        String telefono,
        String direccion
){
}
