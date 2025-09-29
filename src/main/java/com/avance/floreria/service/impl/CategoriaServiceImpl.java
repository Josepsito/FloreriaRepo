package com.avance.floreria.service.impl;

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

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaResponseDTO crearCategoria(String nombre, String descripcion, String imagenURL) {
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);
        categoria.setImagenURL(imagenURL);

        Categoria nueva = categoriaRepository.save(categoria);
        return CategoriaMapper.toDTO(nueva);
    }


    @Override
    public CategoriaResponseDTO findById(Long id) {
        return CategoriaMapper.toDTO(categoriaRepository.findById(id).orElseThrow());
    }

    @Override
    public List<CategoriaResponseDTO> findAll() {
        return categoriaRepository.findAll().stream()
                .map(CategoriaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
