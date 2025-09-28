import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../service/auth';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterModule, CommonModule, FormsModule],
  templateUrl: './header.html',
  styleUrls: ['./header.css']
})
export class Header {
  usuario: string | null = null;
  username: string = '';
  password: string = '';
  mostrarLogin: boolean = false;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.usuario = this.authService.getUsuario();
  }

  abrirLogin(): void {
    this.mostrarLogin = true;
  }

  cerrarLogin(): void {
    this.mostrarLogin = false;
  }

  iniciarSesion(): void {
    if (!this.username || !this.password) return;

    this.authService.login({ usuario: this.username, password: this.password })
      .subscribe({
        next: (res) => {
          this.authService.setUsuario(this.username);
          this.usuario = this.username;
          this.cerrarLogin();
          console.log('Login exitoso', res);
        },
        error: (err) => console.error('Error en login', err)
      });
  }

  logout(): void {
    this.authService.logout();
    this.usuario = null;
  }
}
