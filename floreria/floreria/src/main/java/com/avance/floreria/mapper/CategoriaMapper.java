package com.avance.floreria.mapper;

import com.avance.floreria.dto.response.CategoriaResponseDTO;
import com.avance.floreria.entity.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public CategoriaResponseDTO ToDTO(Categoria categoria){
        return new CategoriaResponseDTO(
                categoria.getNombre()
        );
    }

}
