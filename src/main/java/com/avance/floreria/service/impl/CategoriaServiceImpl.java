package com.avance.floreria.service.impl;

import com.avance.floreria.dto.request.CategoriaRequestDTO;
import com.avance.floreria.dto.response.CategoriaResponseDTO;
import com.avance.floreria.entity.Categoria;
import com.avance.floreria.mapper.CategoriaMapper;
import com.avance.floreria.repository.CategoriaRepository;
import com.avance.floreria.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaMapper categoriaMapper;

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaMapper categoriaMapper, CategoriaRepository categoriaRepository) {
        this.categoriaMapper = categoriaMapper;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaResponseDTO crearCategoria(CategoriaRequestDTO categoriaRequestDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaRequestDTO);
        categoria = categoriaRepository.save(categoria);

        return categoriaMapper.toDTO(categoria);
    }


    @Override
    public CategoriaResponseDTO findById(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()->new RuntimeException("Categoria no encontrada"));
        return categoriaMapper.toDTO(categoria);
    }

    @Override
    public List<CategoriaResponseDTO> findAll() {
        return categoriaMapper.toDTOList(categoriaRepository.findAll());
    }
}
