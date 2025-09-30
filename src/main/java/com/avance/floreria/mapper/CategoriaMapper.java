package com.avance.floreria.mapper;

import com.avance.floreria.dto.request.CategoriaRequestDTO;
import com.avance.floreria.dto.response.CategoriaResponseDTO;
import com.avance.floreria.entity.Categoria;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaMapper {

    public CategoriaResponseDTO toDTO(Categoria categoria) {
        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getDescripcion(),
                categoria.getImagenURL(),
                categoria.getImagenSecundariaURL()
        );

    }

    public Categoria toEntity(CategoriaRequestDTO categoriaRequestDTO){
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaRequestDTO.nombre());
        categoria.setDescripcion(categoriaRequestDTO.descripcion());
        categoria.setImagenURL(categoriaRequestDTO.imagenURL());
        categoria.setImagenSecundariaURL(categoriaRequestDTO.imagenSecundariaURL());;
        categoria.setProductos(new ArrayList<>());

        return categoria;
    }

    public List<CategoriaResponseDTO> toDTOList(List<Categoria> categorias) {
        return categorias.stream().map(this::toDTO).toList();
    }

}

