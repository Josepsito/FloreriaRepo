import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Producto } from './producto';

export interface ItemCarrito {
  producto: Producto;
  cantidad: number;
}

export interface Pedido {
  id: string; // UUID del pedido
  items: ItemCarrito[];
  total: number;
  estado: 'Pendiente' | 'Pagado' | 'Enviado';
  fecha: string;
}

@Injectable({
  providedIn: 'root'
})
export class CarritoService {
  private items: ItemCarrito[] = [];
  private carritoId: string;
  private pedidos: Pedido[] = [];

  carrito$ = new BehaviorSubject<ItemCarrito[]>([]);
  pedidos$ = new BehaviorSubject<Pedido[]>([]);

  constructor() {
    // ID único del carrito
    const guardadoId = localStorage.getItem('carritoId');
    if (guardadoId) this.carritoId = guardadoId;
    else {
      this.carritoId = crypto.randomUUID();
      localStorage.setItem('carritoId', this.carritoId);
    }

    // Cargar carrito
    const guardadoCarrito = localStorage.getItem('carrito');
    if (guardadoCarrito) {
      this.items = JSON.parse(guardadoCarrito);
      this.carrito$.next(this.items);
    }

    // Cargar pedidos
    const guardadoPedidos = localStorage.getItem('pedidos');
    if (guardadoPedidos) {
      this.pedidos = JSON.parse(guardadoPedidos);
      this.pedidos$.next(this.pedidos);
    }
  }

  private actualizarCarrito() {
    this.carrito$.next(this.items);
    localStorage.setItem('carrito', JSON.stringify(this.items));
  }

  private actualizarPedidos() {
    this.pedidos$.next(this.pedidos);
    localStorage.setItem('pedidos', JSON.stringify(this.pedidos));
  }

  // -----------------------
  // Carrito
  // -----------------------
  agregarProducto(producto: Producto, cantidad: number = 1) {
    const existente = this.items.find(i => i.producto.id === producto.id);
    if (existente) existente.cantidad += cantidad;
    else this.items.push({ producto, cantidad });
    this.actualizarCarrito();
  }

  quitarProducto(id: number) {
    this.items = this.items.filter(i => i.producto.id !== id);
    this.actualizarCarrito();
  }

  cambiarCantidad(id: number, cantidad: number) {
    const item = this.items.find(i => i.producto.id === id);
    if (item) {
      item.cantidad = cantidad;
      if (cantidad <= 0) this.quitarProducto(id);
      else this.actualizarCarrito();
    }
  }

  limpiarCarrito() {
    this.items = [];
    this.actualizarCarrito();
  }

  obtenerTotal(): number {
    return this.items.reduce((acc, i) => acc + i.producto.precio * i.cantidad, 0);
  }

  // -----------------------
  // Pedidos
  // -----------------------
  crearPedido() {
    if (this.items.length === 0) return;

    const nuevoPedido: Pedido = {
      id: crypto.randomUUID(),
      items: [...this.items],
      total: this.obtenerTotal(),
      estado: 'Pendiente',
      fecha: new Date().toISOString()
    };

    this.pedidos.push(nuevoPedido);
    this.actualizarPedidos();
    this.limpiarCarrito(); // vacía el carrito después de crear pedido
  }

  cambiarEstadoPedido(pedidoId: string, estado: 'Pendiente' | 'Pagado' | 'Enviado') {
    const pedido = this.pedidos.find(p => p.id === pedidoId);
    if (pedido) {
      pedido.estado = estado;
      this.actualizarPedidos();
    }
  }
}
