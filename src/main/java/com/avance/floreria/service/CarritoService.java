package com.avance.floreria.service;

import com.avance.floreria.dto.response.CarritoResponseDTO;

import java.util.List;

public interface CarritoService {
    CarritoResponseDTO findById(int id);

    List<CarritoResponseDTO> findAll();
}
