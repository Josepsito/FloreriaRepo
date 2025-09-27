package com.avance.floreria.controller;

import com.avance.floreria.dto.response.CarritoResponseDTO;
import com.avance.floreria.service.CarritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carritos")
@RequiredArgsConstructor
public class CarritoController {

    private final CarritoService carritoService;

    @GetMapping("/{id}")
    public ResponseEntity<CarritoResponseDTO> obtenerPorID(@PathVariable int id) {
        return ResponseEntity.ok(carritoService.findById(id));
    }


}
