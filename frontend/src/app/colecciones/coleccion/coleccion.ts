import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Header  } from '../../shared/header/header';
import { Footer  } from '../../shared/footer/footer';

@Component({
  selector: 'app-coleccion',
  standalone: true,
  imports: [CommonModule, FormsModule, Header , Footer ],
  templateUrl: './coleccion.html',
  styleUrls: ['./coleccion.css']
})
export class ColeccionComponent implements OnInit {
  nombreColeccion: string = '';
  bannerURL: string = 'https://i.postimg.cc/j2BTQksj/banner-Flor-Rosa.png';
  productos = [
    { nombre: 'Ramo Rosa', precio: 25.00, stock: 10, descripcion: 'Hermoso ramo de rosas', imagenURL: 'https://i.postimg.cc/nc8Sttwp/florcate2.png' },
    { nombre: 'Ramo Tulipán', precio: 30.00, stock: 5, descripcion: 'Elegante ramo de tulipanes', imagenURL: 'https://i.postimg.cc/nc8Sttwp/florcate2.png' }
  ];
  productoSeleccionado: any = null;
  cantidadSeleccionada: number = 1;

  constructor(private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.nombreColeccion = params.get('nombre') || 'Colección';
    });
  }

  ngOnInit(): void {}

  abrirModal(producto: any) {
    this.productoSeleccionado = producto;
    this.cantidadSeleccionada = 1;
  }

  cerrarModal() {
    this.productoSeleccionado = null;
  }

  agregarCarrito(producto: any) {
    console.log('Agregar al carrito', producto, this.cantidadSeleccionada);
  }
}
