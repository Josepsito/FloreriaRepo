import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UsuarioService } from './service/usuario';
import { RouterOutlet } from '@angular/router';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule, HttpClientModule, RouterOutlet],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  protected readonly title = signal('Jardín Secreto');
   usuario: string | null = null;
   constructor(private usuarioService: UsuarioService) {}

    ngOnInit(): void {
      this.usuario = this.usuarioService.getUsuario();
    }
}
