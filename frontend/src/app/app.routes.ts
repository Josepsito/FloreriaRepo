import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Catalogo } from './catalogo/catalogo';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'catalogo', component: Catalogo }
];
