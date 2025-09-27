package com.avance.floreria.mapper;

import com.avance.floreria.dto.response.CarritoResponseDTO;
import com.avance.floreria.entity.Carrito;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarritoMapper {

    public CarritoResponseDTO toDTO(Carrito carrito) {
        return new CarritoResponseDTO(
                carrito.getUsuario().getId(),
                carrito.getProducto().getId(),
                carrito.getCantidad()
        );
    }

    public List<CarritoResponseDTO> toDTOList (List<Carrito> carritos){
        return carritos.stream().map((this::toDTO)).toList();
    }

}
