package com.avance.floreria.entity;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Productos")

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

    public Producto(Long id, String nombre, String descripcion, BigDecimal precio, Integer stock, String imagenURL, Categoria categoria, List<Carrito> carritos, List<DetallePedido> detallesPedido) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.imagenURL = imagenURL;
        this.categoria = categoria;
        this.carritos = carritos;
        this.detallesPedido = detallesPedido;
    }

    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }

    public List<DetallePedido> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallePedido> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }
}
