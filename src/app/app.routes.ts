import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';  // Assurez-vous que HomeComponent est bien importé

// Définition des routes
export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },  // Redirection vers /home par défaut
  { path: 'home', component: HomeComponent },  // Route vers /home
];
