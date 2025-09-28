import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-admin-agregar',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './admin-agregar.html',
  styleUrls: ['./admin-agregar.css']
})
export class AdminAgregar {
  defaultImg = 'https://thumb.ac-illust.com/b1/b170870007dfa419295d949814474ab2_t.jpeg';
  producto = {
    nombre: '',
    descripcion: '',
    precio: 0,
    imagen: ''
  };

  onSubmit() {
    console.log('Producto agregado:', this.producto);
    alert(`Producto "${this.producto.nombre}" agregado (simulado).`);
    this.producto = { nombre: '', descripcion: '', precio: 0, imagen: '' };
  }
}
