import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';  // Importation du composant autonome

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,  // Le module de routage
  ],
  providers: []  // Si tu n'as pas de services à ajouter
})
export class AppModule { }
