package com.avance.floreria.controller;

import com.avance.floreria.dto.response.CategoriaResponseDTO;
import com.avance.floreria.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> obtenerPorID(@PathVariable int id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

}