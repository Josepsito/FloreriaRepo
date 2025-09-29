package com.avance.floreria.dto.request;


public class CategoriaRequestDTO {

    private String nombre;
    private String descripcion;
    private String imagenURL;

    public CategoriaRequestDTO() {
    }

    public CategoriaRequestDTO(String nombre, String descripcion, String imagenURL) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenURL = imagenURL;
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
