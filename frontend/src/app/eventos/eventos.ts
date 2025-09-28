import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-eventos',
  standalone: true,
  imports: [CommonModule,FormsModule, RouterModule],
  templateUrl: './eventos.html',
  styleUrl: './eventos.css'
})
export class Eventos {
  flor: number = 5;
    cantidad: number = 10;
    extras: number[] = [];
    precio: number = 0;

    calcularPrecio() {
      let total = this.flor * this.cantidad;
      this.extras.forEach(extra => total += extra);
      this.precio = total;
    }

    actualizarExtras(event: any, valor: number) {
      if (event.target.checked) {
        this.extras.push(valor);
      } else {
        this.extras = this.extras.filter(v => v !== valor);
      }
    }
  scrollTo(seccion: string) {
      const el = document.getElementById(seccion);
      if (el) {
        el.scrollIntoView({ behavior: 'smooth' });
      }
    }
}
