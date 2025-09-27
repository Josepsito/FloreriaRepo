package com.avance.floreria.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pedidos")

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PedidoID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UsuarioID", nullable = false)
    private Usuario usuario;

    @Column(name = "FechaPedido")
    private LocalDate fechaPedido;

    @Column(name = "Estado", length = 50)
    private String estado;

    @Column(name = "Total")
    private BigDecimal total;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detallesPedido;

    public Pedido(Long id, Usuario usuario, LocalDate fechaPedido, String estado, BigDecimal total, List<DetallePedido> detallesPedido) {
        this.id = id;
        this.usuario = usuario;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.total = total;
        this.detallesPedido = detallesPedido;
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<DetallePedido> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallePedido> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }
}
