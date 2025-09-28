import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-admin-agregar',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
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
    this.producto = { nombre: '', descripcion: '', precio: 0, imagen: '' };
  }
}
