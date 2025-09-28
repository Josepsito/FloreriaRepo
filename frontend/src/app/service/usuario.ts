import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class UsuarioService {
  private usuario: string | null = null;

  setUsuario(nombre: string) {
    this.usuario = nombre;
    localStorage.setItem('usuario', nombre);
  }

  getUsuario(): string | null {
    return this.usuario || localStorage.getItem('usuario');
  }

  cerrarSesion() {
    this.usuario = null;
    localStorage.removeItem('usuario');
  }
}
