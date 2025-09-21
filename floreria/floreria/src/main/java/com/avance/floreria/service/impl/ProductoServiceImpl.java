package com.avance.floreria.service.impl;

import com.avance.floreria.dto.request.ProductoRequestDTO;
import com.avance.floreria.dto.response.ProductoResponseDTO;
import com.avance.floreria.entity.Producto;
import com.avance.floreria.mapper.ProductoMapper;
import com.avance.floreria.repository.ProductoRepository;
import com.avance.floreria.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public List<ProductoResponseDTO> obtenerTodosLosProductos(){
        List<Producto> producto = productoRepository.findAll();
        return productoMapper.toDTOList(producto);
    }

    @Override
    public ProductoResponseDTO obtenerPorID(Long id){
        Producto producto = productoRepository.findById(id).orElseThrow(()->new RuntimeException("No existe un producto con ese ID"));
        return productoMapper.toDTO(producto);
    }
    @Override
    public void eliminarProductoPorID(Long id){
        productoRepository.deleteById(id);
    }

    @Override
    public ProductoResponseDTO nuevoProducto(ProductoRequestDTO productoDTO){
        Producto producto = productoMapper.toEntity(productoDTO);
        productoRepository.save(producto);
        return productoMapper.toDTO(producto);
    }

}
