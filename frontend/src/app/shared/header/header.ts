import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from '../../service/usuario';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterModule, CommonModule, FormsModule],
  templateUrl: './header.html',
  styleUrls: ['./header.css']
})
export class Header {
  // Estado de modales
  mostrarLogin = false;
  mostrarRegistro = false;

  // Campos de login
  email: string = '';
  password: string = '';

  // Campos de registro
  nombreReg: string = '';
  emailReg: string = '';
  passwordReg: string = '';
  telefonoReg: string = '';    // opcional
  direccionReg: string = '';   // opcional

  constructor(private usuarioService: UsuarioService) {}

  // Abrir modales
  abrirLogin() {
    this.mostrarLogin = true;
    this.mostrarRegistro = false;
  }

  abrirRegistro() {
    this.mostrarRegistro = true;
    this.mostrarLogin = false;
  }

  // Cerrar modales
  cerrarModales() {
    this.mostrarLogin = false;
    this.mostrarRegistro = false;
  }

  // LOGIN
  onLogin() {
    this.usuarioService.login({
      email: this.email,
      password: this.password
    }).subscribe(
      res => {
        alert('Inicio de sesión exitoso');
        this.usuarioService.setUsuario(res.nombre || res.email);
        this.cerrarModales();
      },
      err => {
        alert('Error en login');
        console.error(err);
      }
    );
  }

  // REGISTRO
  onRegister() {
    this.usuarioService.registrar({
      nombre: this.nombreReg,
      email: this.emailReg,
      password: this.passwordReg,
      telefono: this.telefonoReg,
      direccion: this.direccionReg
    }).subscribe(
      res => {
        alert('Registro exitoso');
        this.usuarioService.setUsuario(res.nombre || res.email);
        this.cerrarModales();
      },
      err => {
        alert('Error en registro');
        console.error(err);
      }
    );
  }
}
