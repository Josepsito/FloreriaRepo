package com.avance.floreria.controller;

import com.avance.floreria.dto.response.CarritoResponseDTO;
import com.avance.floreria.service.CarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carritos/")

public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @PostMapping("agregar/{idProducto}/{cantidad}")
    public ResponseEntity<String> agregarProductoAlCarrito(
            @PathVariable long idProducto,
            @PathVariable int cantidad) {
        carritoService.añadirProductoAlCarrrito(idProducto, cantidad);
        return ResponseEntity.ok("Producto añadido al carrito correctamente.");
    }

    @DeleteMapping("retirar/{idProducto}")
    public ResponseEntity<String> retirarProductoDelCarrito(
            @PathVariable long idProducto) {
        carritoService.retirarDelCarrito(idProducto);
        return ResponseEntity.ok("Producto retirado del carrito correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarritoResponseDTO> obtenerPorID(@PathVariable int id) {
        return ResponseEntity.ok(carritoService.findById(id));
    }

    @GetMapping
    public  ResponseEntity<List<CarritoResponseDTO>> verTodosLosCarritos(){
        return ResponseEntity.ok(carritoService.findAll());
    }

}
