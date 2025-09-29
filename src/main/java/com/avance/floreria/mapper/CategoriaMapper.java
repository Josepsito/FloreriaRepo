package com.avance.floreria.mapper;

import com.avance.floreria.dto.response.CategoriaResponseDTO;
import com.avance.floreria.entity.Categoria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaMapper {

    public CategoriaResponseDTO ToDTO(Categoria categoria) {
        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getDescripcion(),
                categoria.getImagenURL()
        );

    }

    public List<CategoriaResponseDTO> ToDTOList(List<Categoria> categorias) {
        return categorias.stream().map(this::ToDTO).toList();
    }

    public static CategoriaResponseDTO toDTO(Categoria c) {
        return new CategoriaResponseDTO(c.getId(), c.getNombre(), c.getDescripcion(), c.getImagenURL());
    }

}

