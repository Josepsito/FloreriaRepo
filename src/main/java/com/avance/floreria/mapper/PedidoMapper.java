package com.avance.floreria.mapper;

import com.avance.floreria.dto.request.PedidoRequestDTO;
import com.avance.floreria.dto.response.PedidoResponseDTO;
import com.avance.floreria.entity.Pedido;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;


@Component
public class PedidoMapper {

    private final DetallePedidoMapper detallePedidoMapper;

    public PedidoMapper(DetallePedidoMapper detallePedidoMapper) {
        this.detallePedidoMapper = detallePedidoMapper;
    }

    public PedidoResponseDTO toDTO(Pedido pedido) {
        return new PedidoResponseDTO(
                pedido.getUsuario().getId(),
                pedido.getFechaPedido(),
                pedido.getTotal().doubleValue(),
                detallePedidoMapper.toDTOList(pedido.getDetallesPedido())
        );
    }

}
