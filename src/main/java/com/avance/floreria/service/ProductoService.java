package com.avance.floreria.service;

import com.avance.floreria.dto.request.ProductoRequestDTO;
import com.avance.floreria.dto.response.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {

    List<ProductoResponseDTO> obtenerTodosLosProductos();

    ProductoResponseDTO obtenerPorID(Long id);

    void eliminarProductoPorID(Long id);

    ProductoResponseDTO nuevoProducto(ProductoRequestDTO productoDTO);

    ProductoResponseDTO actualizarProducto(Long id, ProductoRequestDTO dto);

    List<ProductoResponseDTO> obtenerPorCategoria(String nombreCategoria);
}
