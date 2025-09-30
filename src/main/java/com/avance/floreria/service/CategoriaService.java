package com.avance.floreria.service;

import com.avance.floreria.dto.request.CategoriaRequestDTO;
import com.avance.floreria.dto.response.CategoriaResponseDTO;
import com.avance.floreria.entity.Categoria;
import com.avance.floreria.mapper.CategoriaMapper;
import com.avance.floreria.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public interface CategoriaService {

    CategoriaResponseDTO crearCategoria(CategoriaRequestDTO categoriaRequestDTO);

    CategoriaResponseDTO findById(Long id);

    List<CategoriaResponseDTO> findAll();
}

