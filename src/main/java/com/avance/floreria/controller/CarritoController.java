package com.avance.floreria.controller;

import com.avance.floreria.dto.response.CarritoResponseDTO;
import com.avance.floreria.service.CarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carritos")

public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarritoResponseDTO> obtenerPorID(@PathVariable int id) {
        return ResponseEntity.ok(carritoService.findById(id));
    }


}
