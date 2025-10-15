package com.avance.floreria.controller;

import com.avance.floreria.dto.request.PedidoRequestDTO;
import com.avance.floreria.dto.response.PedidoResponseDTO;
import com.avance.floreria.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> obtenerPedido(@PathVariable long id) {
        PedidoResponseDTO pedido = pedidoService.obtenerPedidoPorID(id);
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> crearPedido(@RequestBody PedidoRequestDTO pedidoDTO) {
        PedidoResponseDTO nuevoPedido = pedidoService.nuevoPedido(pedidoDTO);
        return ResponseEntity.ok(nuevoPedido);
    }

    @PostMapping("/comprarCarrito")
    public ResponseEntity<String> comprarProductosDelCarrito() {
        pedidoService.comprarProductosDelCarrito();
        return ResponseEntity.ok("Se realizo la compra correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable long id) {
        pedidoService.eliminarPedidoPorID(id);
        return ResponseEntity.noContent().build();
    }
}
