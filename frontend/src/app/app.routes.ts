import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Catalogo } from './catalogo/catalogo';
import { Blog } from './blog/blog';
import { Novias } from './novias/novias';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'catalogo', component: Catalogo },
  { path: 'blog', component: Blog },
  { path: 'novias', component: Novias }
];
