package com.avance.floreria.mapper;

import com.avance.floreria.dto.request.ProductoRequestDTO;
import com.avance.floreria.dto.response.ProductoResponseDTO;
import com.avance.floreria.entity.Categoria;
import com.avance.floreria.entity.Producto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductoMapper {

    public Producto toEntity(ProductoRequestDTO dto, Categoria categoria) {
        Producto producto = new Producto();
        producto.setNombre(dto.nombre());
        producto.setDescripcion(dto.descripcion());
        producto.setPrecio(java.math.BigDecimal.valueOf(dto.precio()));
        producto.setStock(dto.stock());
        producto.setImagenURL(dto.imagenURL());
        producto.setCategoria(categoria);
        return producto;
    }

    public ProductoResponseDTO toDTO(Producto producto) {
        return new ProductoResponseDTO(
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getImagenURL(),
                producto.getCategoria() != null ? producto.getCategoria().getId() : 0
        );
    }

    public List<ProductoResponseDTO> toDTOList(List<Producto> productos) {
        return productos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
