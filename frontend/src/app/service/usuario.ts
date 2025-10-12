import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiUrl = 'http://localhost:8080'; // Ajusta si tu backend usa otra ruta

  constructor(private http: HttpClient) {}

  // LOGIN
  login(credenciales: { email: string; password: string }): Observable<any> {
    return this.http.post(`${this.apiUrl}/api/auth/login`, credenciales);
  }

  // REGISTRO
  registrar(usuario: {
    nombre: string;
    email: string;
    password: string;
    telefono?: string;
    direccion?: string;
  }): Observable<any> {

    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post(`${this.apiUrl}/api/auth/register`, usuario);
  }

  // Guardar usuario en localStorage
  setUsuario(nombre: string) {
    localStorage.setItem('usuario', nombre);
  }

  // Obtener usuario logueado
  getUsuario(): string | null {
    return localStorage.getItem('usuario');
  }

  // Cerrar sesión
  logout() {
    localStorage.removeItem('usuario');
  }

  // Verificar si hay sesión activa
  isLoggedIn(): boolean {
    return !!localStorage.getItem('usuario');
  }
}
