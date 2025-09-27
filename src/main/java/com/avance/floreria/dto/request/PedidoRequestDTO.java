package com.avance.floreria.dto.request;

import java.time.LocalDate;
import java.util.List;

public record PedidoRequestDTO (
        long usuarioID,
        LocalDate fechaPedido,
        List<DetallePedidoRequestDTO> detallePedidoRequestDTO
){
}
