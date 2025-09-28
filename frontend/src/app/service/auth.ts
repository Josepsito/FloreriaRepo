import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  // Login: llama al backend
  login(credenciales: { usuario: string; password: string }): Observable<any> {
    return this.http.post(`${this.apiUrl}/auth/login`, credenciales);
  }

  // Guarda usuario o token en localStorage
  setUsuario(usuario: string): void {
    localStorage.setItem('usuario', usuario);
  }

  // Obtiene el usuario actual
  getUsuario(): string | null {
    return localStorage.getItem('usuario');
  }

  // Cerrar sesión
  logout(): void {
    localStorage.removeItem('usuario');
  }

  // Verificar si hay sesión activa
  isLoggedIn(): boolean {
    return !!localStorage.getItem('usuario');
  }
}
