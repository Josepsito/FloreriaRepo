package com.avance.floreria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsuarioID")
    private Long id;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "Email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "PasswordHash", nullable = false, length = 200)
    private String passwordHash;

    @Column(name = "Telefono", length = 20)
    private String telefono;

    @Column(name = "Direccion", length = 200)
    private String direccion;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> carritos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

}
