package com.avance.floreria.service.impl;

import com.avance.floreria.dto.response.CategoriaResponseDTO;
import com.avance.floreria.entity.Categoria;
import com.avance.floreria.mapper.CategoriaMapper;
import com.avance.floreria.repository.CategoriaRepository;
import com.avance.floreria.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public CategoriaResponseDTO findById(int id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()->new RuntimeException("Categoria no encontrada"));
        return categoriaMapper.ToDTO(categoria);
    }

    @Override
    public List<CategoriaResponseDTO> findAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categoriaMapper.ToDTOList(categorias);
    }

}
