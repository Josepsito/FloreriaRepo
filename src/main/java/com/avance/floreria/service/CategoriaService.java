package com.avance.floreria.service;

import com.avance.floreria.dto.response.CategoriaResponseDTO;

import java.util.List;

public interface CategoriaService {
    CategoriaResponseDTO findById(int id);

    List<CategoriaResponseDTO> findAll();
}
