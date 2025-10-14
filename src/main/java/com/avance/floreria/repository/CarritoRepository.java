package com.avance.floreria.repository;

import com.avance.floreria.entity.Carrito;
import com.avance.floreria.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    Optional<Carrito> findByUsuarioAndProductoId(Usuario usuario, Long productoId);

}
