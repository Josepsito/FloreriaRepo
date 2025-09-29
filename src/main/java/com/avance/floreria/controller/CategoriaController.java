package com.avance.floreria.controller;

import com.avance.floreria.dto.request.CategoriaRequestDTO;
import com.avance.floreria.dto.response.CategoriaResponseDTO;
import com.avance.floreria.dto.response.ProductoResponseDTO;
import com.avance.floreria.service.ProductoService;
import com.avance.floreria.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final ProductoService productoService;

    public CategoriaController(CategoriaService categoriaService, ProductoService productoService) {
        this.categoriaService = categoriaService;
        this.productoService = productoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> obtenerPorID(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> crearCategoria(@RequestBody CategoriaRequestDTO dto) {
        CategoriaResponseDTO nueva = categoriaService.crearCategoria(
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getImagenURL()
        );
        return ResponseEntity.ok(nueva);
    }

    @GetMapping("/categoria/{nombre}")
    public ResponseEntity<List<ProductoResponseDTO>> obtenerPorCategoria(@PathVariable String nombre) {
        List<ProductoResponseDTO> productos = productoService.obtenerPorCategoria(nombre);
        return ResponseEntity.ok(productos);
    }
}
