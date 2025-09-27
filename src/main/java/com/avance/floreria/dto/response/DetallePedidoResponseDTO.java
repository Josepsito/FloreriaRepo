package com.avance.floreria.dto.response;

public record DetallePedidoResponseDTO(
        long productoID,
        int cantidad,
        double precioUnitario
){
}
