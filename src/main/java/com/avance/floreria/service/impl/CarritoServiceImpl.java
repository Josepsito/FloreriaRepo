package com.avance.floreria.service.impl;

import com.avance.floreria.dto.response.CarritoResponseDTO;
import com.avance.floreria.entity.Carrito;
import com.avance.floreria.mapper.CarritoMapper;
import com.avance.floreria.repository.CarritoRepository;
import com.avance.floreria.service.CarritoService;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceImpl implements CarritoService {

    private final CarritoRepository carritoRepository;
    private final CarritoMapper carritoMapper;

    public CarritoServiceImpl(CarritoRepository carritoRepository, CarritoMapper carritoMapper) {
        this.carritoRepository = carritoRepository;
        this.carritoMapper = carritoMapper;
    }

    @Override
    public CarritoResponseDTO findById(int id) {
        Carrito carrito = carritoRepository.findById(id).orElseThrow(()->new RuntimeException("No existe un carrito con ese ID"));
        return carritoMapper.toDTO(carrito);
    }


}
