package com.avance.floreria.service.impl;

import com.avance.floreria.dto.request.UsuarioRequestDTO;
import com.avance.floreria.dto.response.UsuarioResponseDTO;
import com.avance.floreria.entity.Usuario;
import com.avance.floreria.mapper.UsuarioMapper;
import com.avance.floreria.repository.UsuarioRepository;
import com.avance.floreria.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioResponseDTO obtenerUsuarioPorID(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario no encontrado"));
        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO nuevoUsuario(UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = usuarioMapper.toEntity(usuarioRequestDTO);
        usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> obtenerTodosLosUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarioMapper.toDTOList(usuarios);
    }

    @Override
    public void eliminarUsuarioPorID(Long id){
        usuarioRepository.deleteById(id);
    }

}
