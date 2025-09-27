package com.avance.floreria.mapper;

import com.avance.floreria.dto.request.UsuarioRequestDTO;
import com.avance.floreria.dto.response.UsuarioResponseDTO;
import com.avance.floreria.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioMapper {

    private final PasswordEncoder passwordEncoder;

    public UsuarioMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponseDTO toDTO (Usuario usuario) {
        return new UsuarioResponseDTO (
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getDireccion()
        );
    }

    public List<UsuarioResponseDTO> toDTOList(List<Usuario> usuarios) {
        return usuarios.stream().map(this::toDTO).toList();
    }

    public Usuario toEntity (UsuarioRequestDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setCarritos(new ArrayList<>());
        usuario.setDireccion(usuarioDTO.direccion());
        usuario.setNombre(usuarioDTO.nombre());
        usuario.setEmail(usuarioDTO.email());
        usuario.setTelefono(usuarioDTO.telefono());
        usuario.setPasswordHash(passwordEncoder.encode(usuarioDTO.password()));
        usuario.setPedidos(new ArrayList<>());
        return usuario;
    }

}
