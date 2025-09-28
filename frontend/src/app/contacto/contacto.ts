import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Header } from '../shared/header/header';
import { Footer } from '../shared/footer/footer';

@Component({
  selector: 'app-contacto',
  standalone: true,
  imports: [CommonModule, RouterModule, Header, Footer],
  templateUrl: './contacto.html',
  styleUrls: ['./contacto.css']
})
export class Contacto {}
