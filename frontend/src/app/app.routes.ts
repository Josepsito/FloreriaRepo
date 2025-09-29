import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Catalogo } from './catalogo/catalogo';
import { Blog } from './blog/blog';
import { Novias } from './novias/novias';
import { Contacto } from './contacto/contacto';
import { Eventos } from './eventos/eventos';
import { AdminAgregar } from './admin-agregar/admin-agregar';
import { ColeccionComponent } from './colecciones/coleccion/coleccion';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'catalogo', component: Catalogo },
  { path: 'blog', component: Blog },
  { path: 'novias', component: Novias },
  { path: 'contacto', component: Contacto },
  { path: 'eventos', component: Eventos },
  { path: 'admin-agregar', component: AdminAgregar },
  { path: 'coleccion/:nombre', component: ColeccionComponent }
];
