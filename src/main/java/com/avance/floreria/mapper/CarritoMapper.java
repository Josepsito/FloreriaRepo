package com.avance.floreria.mapper;

import com.avance.floreria.dto.response.CarritoResponseDTO;
import com.avance.floreria.entity.Carrito;
import org.springframework.stereotype.Component;

@Component
public class CarritoMapper {

    public CarritoResponseDTO toDTO(Carrito carrito) {
        return new CarritoResponseDTO(
                carrito.getUsuario().getId(),
                carrito.getProducto().getId(),
                carrito.getCantidad()
        );
    }

}
