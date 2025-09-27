package com.avance.floreria.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "DetallePedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DetalleID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PedidoID", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "ProductoID", nullable = false)
    private Producto producto;

    @Column(name = "Cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "PrecioUnitario", nullable = false)
    private BigDecimal precioUnitario;

}