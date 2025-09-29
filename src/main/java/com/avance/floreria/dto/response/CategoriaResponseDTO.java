package com.avance.floreria.dto.response;

public class CategoriaResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String imagenURL;

    public CategoriaResponseDTO() {
    }

    public CategoriaResponseDTO(Long id, String nombre, String descripcion, String imagenURL) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenURL = imagenURL;
    }

    // Getters y setters
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
}
