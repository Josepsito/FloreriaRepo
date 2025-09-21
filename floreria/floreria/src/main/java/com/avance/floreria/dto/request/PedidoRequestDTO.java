package com.avance.floreria.dto.request;

import java.time.LocalDate;

public record PedidoRequestDTO (
        long usuarioID,
        LocalDate fechaPedido,
        long productoID,
        int cantidad
){
}
