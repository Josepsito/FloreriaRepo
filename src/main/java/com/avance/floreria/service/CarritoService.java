package com.avance.floreria.service;

import com.avance.floreria.dto.response.CarritoResponseDTO;

import java.util.List;

public interface CarritoService {
    CarritoResponseDTO findById(long id);

    List<CarritoResponseDTO> findAll();

    void retirarDelCarrito(long idProducto);

    void añadirProductoAlCarrrito(long idProducto, int cantidad);
}
