import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Header } from '../shared/header/header';
import { Footer } from '../shared/footer/footer';

@Component({
  selector: 'app-blog',
  standalone: true,
  imports: [CommonModule, RouterModule, Header, Footer],
  templateUrl: './blog.html',
  styleUrls: ['./blog.css']
})
export class Blog { }
