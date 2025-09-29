package com.avance.floreria.controller;

import com.avance.floreria.dto.request.ProductoRequestDTO;
import com.avance.floreria.dto.response.ProductoResponseDTO;
import com.avance.floreria.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(productoService.obtenerTodosLosProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> obtenerPorID(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.obtenerPorID(id));
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crearProducto(@RequestBody ProductoRequestDTO productoDTO) {
        return ResponseEntity.ok(productoService.nuevoProducto(productoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProductoPorID(id);
        return ResponseEntity.noContent().build();
    }

    // NUEVO ENDPOINT: productos por categoría
    @GetMapping("/categoria/{nombre}")
    public ResponseEntity<List<ProductoResponseDTO>> obtenerPorCategoria(@PathVariable String nombre) {
        List<ProductoResponseDTO> productos = productoService.obtenerPorCategoria(nombre);
        return ResponseEntity.ok(productos);
    }

}
