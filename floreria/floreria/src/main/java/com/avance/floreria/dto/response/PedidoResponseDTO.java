package com.avance.floreria.dto.response;

import java.time.LocalDate;
import java.util.List;

public record PedidoResponseDTO(
        long usuarioID,
        LocalDate fechaPedido,
        double total,
        List<DetallePedidoResponseDTO> detallePedidos
){
}
