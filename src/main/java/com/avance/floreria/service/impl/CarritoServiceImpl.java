package com.avance.floreria.service.impl;

import com.avance.floreria.dto.response.CarritoResponseDTO;
import com.avance.floreria.entity.Carrito;
import com.avance.floreria.entity.Producto;
import com.avance.floreria.entity.Usuario;
import com.avance.floreria.mapper.CarritoMapper;
import com.avance.floreria.repository.CarritoRepository;
import com.avance.floreria.repository.ProductoRepository;
import com.avance.floreria.repository.UsuarioRepository;
import com.avance.floreria.service.CarritoService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoServiceImpl implements CarritoService {

    private final CarritoRepository carritoRepository;
    private final CarritoMapper carritoMapper;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;

    public CarritoServiceImpl(CarritoRepository carritoRepository, CarritoMapper carritoMapper, ProductoRepository productoRepository, UsuarioRepository usuarioRepository) {
        this.carritoRepository = carritoRepository;
        this.carritoMapper = carritoMapper;
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public CarritoResponseDTO findById(long id) {
        Carrito carrito = carritoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No existe un carrito con ese ID"));
        return carritoMapper.toDTO(carrito);
    }

    @Override
    public List<CarritoResponseDTO> findAll() {
        List<Carrito> listaCarrito=carritoRepository.findAll();
        return carritoMapper.toDTOList(listaCarrito);
    }

    @Override
    public void retirarDelCarrito(long idProducto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();

        Carrito carrito = carritoRepository.findByUsuarioAndProductoId(usuario, idProducto)
                .orElseThrow(() -> new RuntimeException("El producto no está en el carrito"));

        carritoRepository.delete(carrito);
    }


    @Override
    public void añadirProductoAlCarrrito(long idProducto, int cantidad){
        Carrito carrito = new Carrito();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));

        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(()->new RuntimeException("No existe un producto con ese ID"));

        carrito.setCantidad(cantidad);
        carrito.setProducto(producto);
        carrito.setUsuario(usuario);

        carritoRepository.save(carrito);
    }

}
