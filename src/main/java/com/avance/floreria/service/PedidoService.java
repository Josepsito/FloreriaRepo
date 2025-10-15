package com.avance.floreria.service;

import com.avance.floreria.dto.request.PedidoRequestDTO;
import com.avance.floreria.dto.response.PedidoResponseDTO;

public interface PedidoService {
    PedidoResponseDTO obtenerPedidoPorID(long id);

    void comprarProductosDelCarrito();

    PedidoResponseDTO nuevoPedido(PedidoRequestDTO pedidoDTO);

    void eliminarPedidoPorID(long id);
}
