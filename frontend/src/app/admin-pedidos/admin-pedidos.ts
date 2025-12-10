import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { CarritoService, Pedido } from '../service/carrito-service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-pedidos',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './admin-pedidos.html',
  styleUrls: ['./admin-pedidos.css']
})
export class AdminPedidos implements OnInit {
  pedidos: Pedido[] = [];
  estados: ('Pendiente' | 'Pagado' | 'Enviado')[] = ['Pendiente', 'Pagado', 'Enviado'];

  pendientesCount: number = 0;
  pagadosCount: number = 0;
  enviadosCount: number = 0;

  filtroEstado: 'Pendiente' | 'Pagado' | 'Enviado' | null = null;

  constructor(private carritoService: CarritoService, private router: Router) {}

  ngOnInit(): void {
    this.carritoService.pedidos$.subscribe(data => {
      this.pedidos = data;

      this.pendientesCount = this.pedidos.filter(p => p.estado === 'Pendiente').length;
      this.pagadosCount = this.pedidos.filter(p => p.estado === 'Pagado').length;
      this.enviadosCount = this.pedidos.filter(p => p.estado === 'Enviado').length;
    });
  }

  get pedidosFiltrados(): Pedido[] {
    if (!this.filtroEstado) return this.pedidos;
    return this.pedidos.filter(p => p.estado === this.filtroEstado);
  }

  toggleFiltro(estado: 'Pendiente' | 'Pagado' | 'Enviado') {
    if (this.filtroEstado === estado) {
      this.filtroEstado = null;
    } else {
      this.filtroEstado = estado;
    }
  }

  cambiarEstado(id: string, estado: 'Pendiente' | 'Pagado' | 'Enviado') {
    this.carritoService.cambiarEstadoPedido(id, estado);

    Swal.fire({
      icon: 'success',
      title: `Estado cambiado a ${estado}`,
      showConfirmButton: false,
      timer: 1500,
      timerProgressBar: true
    });
  }

  cerrarSesion() {
    Swal.fire({
      icon: 'info',
      title: 'Sesión cerrada',
      confirmButtonColor: '#16a34a'
    });
    this.router.navigate(['/']);
  }
}
