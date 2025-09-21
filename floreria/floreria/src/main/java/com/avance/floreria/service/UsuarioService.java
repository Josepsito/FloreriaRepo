package com.avance.floreria.service;

import com.avance.floreria.dto.request.UsuarioRequestDTO;
import com.avance.floreria.dto.response.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO obtenerUsuarioPorID(Long id);

    UsuarioResponseDTO nuevoUsuario(UsuarioRequestDTO usuarioRequestDTO);

    List<UsuarioResponseDTO> obtenerTodosLosUsuarios();

    void eliminarUsuarioPorID(Long id);
}
