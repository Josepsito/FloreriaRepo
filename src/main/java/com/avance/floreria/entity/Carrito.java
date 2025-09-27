package com.avance.floreria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Carrito")

public class Carrito {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CarritoID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UsuarioID", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ProductoID", nullable = false)
    private Producto producto;

    @Column(name = "Cantidad", nullable = false)
    private Integer cantidad;

    public Carrito(Long id, Usuario usuario, Producto producto, Integer cantidad) {
        this.id = id;
        this.usuario = usuario;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Carrito() {
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
