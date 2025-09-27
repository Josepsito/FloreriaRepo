package com.avance.floreria.mapper;

import com.avance.floreria.dto.request.ProductoRequestDTO;
import com.avance.floreria.dto.response.ProductoResponseDTO;
import com.avance.floreria.entity.Producto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductoMapper {

    public ProductoResponseDTO toDTO(Producto producto) {
        return new ProductoResponseDTO(
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio().doubleValue(),
                producto.getStock(),
                producto.getImagenURL(),
                producto.getCategoria().getId()
        );
    }

    public List<ProductoResponseDTO> toDTOList(List<Producto> productos) {
        return productos.stream().map(this::toDTO).toList();
    }

    public Producto toEntity(ProductoRequestDTO productoDTO) {
        Producto producto = new Producto();
        producto.setDescripcion(productoDTO.descripcion());
        producto.setNombre(productoDTO.nombre());
        producto.setPrecio(new BigDecimal(productoDTO.precio()));
        producto.setStock(productoDTO.stock());
        producto.setImagenURL(productoDTO.imagenURL());
        producto.setCarritos(new ArrayList<>());
        producto.setDetallesPedido(new ArrayList<>());
        return producto;
    }


}