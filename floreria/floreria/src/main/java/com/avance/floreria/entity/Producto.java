package com.avance.floreria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductoID")
    private Long id;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Precio", nullable = false)
    private BigDecimal precio;

    @Column(name = "Stock", nullable = false)
    private Integer stock;

    @Column(name = "ImagenURL", length = 300)
    private String imagenURL;

    @ManyToOne
    @JoinColumn(name = "CategoriaID")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> carritos;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detallesPedido;

}
