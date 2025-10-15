package com.avance.floreria.service.impl;

import com.avance.floreria.dto.request.DetallePedidoRequestDTO;
import com.avance.floreria.dto.request.PedidoRequestDTO;
import com.avance.floreria.dto.response.PedidoResponseDTO;
import com.avance.floreria.entity.*;
import com.avance.floreria.mapper.PedidoMapper;
import com.avance.floreria.repository.CarritoRepository;
import com.avance.floreria.repository.PedidoRepository;
import com.avance.floreria.repository.ProductoRepository;
import com.avance.floreria.repository.UsuarioRepository;
import com.avance.floreria.service.PedidoService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final ProductoRepository productoRepository;
    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    private final PedidoMapper pedidoMapper;
    private final CarritoRepository carritoRepository;

    public PedidoServiceImpl(ProductoRepository productoRepository, PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository, PedidoMapper pedidoMapper, CarritoRepository carritoRepository) {
        this.productoRepository = productoRepository;
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
        this.pedidoMapper = pedidoMapper;
        this.carritoRepository = carritoRepository;
    }

    @Override
    public PedidoResponseDTO obtenerPedidoPorID(long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()->new RuntimeException("No existe el pedido con el id " + id));
        return pedidoMapper.toDTO(pedido);
    }

    @Override
    public void comprarProductosDelCarrito() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<Carrito> carritos = carritoRepository.findByUsuario(usuario);

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setEstado("EN PROCESO");
        pedido.setFechaPedido(LocalDate.now());
        BigDecimal total= new BigDecimal(0);
        List<DetallePedido> detalles = new ArrayList<>();

        for (Carrito carrito : carritos) {

            DetallePedido detalle = new DetallePedido();

            detalle.setPedido(pedido);
            detalle.setProducto(carrito.getProducto());
            detalle.setCantidad(carrito.getCantidad());
            detalle.setPrecioUnitario(carrito.getProducto().getPrecio());

            total = total.add(carrito.getProducto().getPrecio()
                    .multiply(BigDecimal.valueOf(carrito.getCantidad())));

            detalles.add(detalle);
        }

        pedido.setDetallesPedido(detalles);
        pedido.setTotal(total);

        pedidoRepository.save(pedido);
        carritoRepository.deleteAll(carritos);
    }

    @Override
    public PedidoResponseDTO nuevoPedido(PedidoRequestDTO pedidoDTO) {
        Usuario usuario = usuarioRepository.findById(pedidoDTO.usuarioID())
                .orElseThrow(() -> new RuntimeException("No existe el usuario"));

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setFechaPedido(LocalDate.now());
        pedido.setEstado("EN PROCESO");

        List<DetallePedido> detallePedidos = new ArrayList<>();
        BigDecimal totalPedido = BigDecimal.ZERO;

        for (DetallePedidoRequestDTO detalleDTO : pedidoDTO.detallePedidoRequestDTO()) {
            Producto producto = productoRepository.findById(detalleDTO.productoID())
                    .orElseThrow(() -> new RuntimeException("No existe el producto con ID " + detalleDTO.productoID()));

            DetallePedido detalle = new DetallePedido();
            detalle.setProducto(producto);
            detalle.setCantidad(detalleDTO.cantidad());
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setPedido(pedido);

            detallePedidos.add(detalle);

            totalPedido = totalPedido.add(producto.getPrecio().multiply(BigDecimal.valueOf(detalleDTO.cantidad())));
        }

        pedido.setDetallesPedido(detallePedidos);
        pedido.setTotal(totalPedido);

        pedidoRepository.save(pedido);

        return pedidoMapper.toDTO(pedido);
    }


    @Override
    public void eliminarPedidoPorID(long id) {
        pedidoRepository.deleteById(id);
    }

}
