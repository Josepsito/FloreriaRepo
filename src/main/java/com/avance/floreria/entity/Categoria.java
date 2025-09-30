package com.avance.floreria.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoriaid")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "imagenURL", length = 255)
    private String imagenURL;

    @Column(name = "imagen_secundariaURL", length = 500)
    private String imagenSecundariaURL;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos;

    public Categoria(Long id, String nombre, String descripcion, String imagenURL, String imagenSecundariaURL, List<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenURL = imagenURL;
        this.imagenSecundariaURL = imagenSecundariaURL;
        this.productos = productos;
    }

    public Categoria() {

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

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public String getImagenSecundariaURL() {
        return imagenSecundariaURL;
    }

    public void setImagenSecundariaURL(String imagenSecundariaURL) {
        this.imagenSecundariaURL = imagenSecundariaURL;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
