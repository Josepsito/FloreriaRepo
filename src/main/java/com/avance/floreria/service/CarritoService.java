package com.avance.floreria.service;

import com.avance.floreria.dto.response.CarritoResponseDTO;

public interface CarritoService {
    CarritoResponseDTO findById(int id);
}
