package com.avance.floreria.service.impl;

import com.avance.floreria.dto.request.ProductoRequestDTO;
import com.avance.floreria.dto.response.ProductoResponseDTO;
import com.avance.floreria.entity.Categoria;
import com.avance.floreria.entity.Producto;
import com.avance.floreria.repository.CategoriaRepository;
import com.avance.floreria.repository.ProductoRepository;
import com.avance.floreria.service.ProductoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<ProductoResponseDTO> obtenerTodosLosProductos() {
        return productoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoResponseDTO obtenerPorID(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return mapToDTO(producto);
    }

    @Override
    public void eliminarProductoPorID(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public ProductoResponseDTO nuevoProducto(ProductoRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.categoriaID())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Producto producto = new Producto();
        producto.setNombre(dto.nombre());
        producto.setDescripcion(dto.descripcion());
        producto.setPrecio(BigDecimal.valueOf(dto.precio()));
        producto.setStock(dto.stock());
        producto.setImagenURL(dto.imagenURL());
        producto.setCategoria(categoria);

        producto = productoRepository.save(producto);
        return mapToDTO(producto);
    }

    @Override
    public List<ProductoResponseDTO> obtenerPorCategoria(String nombreCategoria) {
        return productoRepository.findAll()
                .stream()
                .filter(p -> p.getCategoria().getNombre().equalsIgnoreCase(nombreCategoria))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ProductoResponseDTO mapToDTO(Producto producto) {
        return new ProductoResponseDTO(
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getImagenURL(),
                producto.getCategoria().getId()
        );
    }
}
