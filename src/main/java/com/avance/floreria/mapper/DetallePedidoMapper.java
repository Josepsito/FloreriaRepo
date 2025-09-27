package com.avance.floreria.mapper;

import com.avance.floreria.dto.request.PedidoRequestDTO;
import com.avance.floreria.dto.response.DetallePedidoResponseDTO;
import com.avance.floreria.entity.DetallePedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DetallePedidoMapper {

    public DetallePedidoResponseDTO toDTO(DetallePedido pedido){
        return new DetallePedidoResponseDTO(
                pedido.getProducto().getId(),
                pedido.getCantidad(),
                pedido.getPrecioUnitario().doubleValue()
        );
    }

    public List<DetallePedidoResponseDTO> toDTOList(List<DetallePedido> pedidos){
        return pedidos.stream().map(this::toDTO).toList();
    }


}
