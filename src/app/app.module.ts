// app.module.ts
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule } from "@angular/forms"; // Importez FormsModule

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NavbarComponent } from "./navbar/navbar.component";
import { MatListModule } from "@angular/material/list";
import { MatIconModule } from "@angular/material/icon";
import { MatButtonModule } from "@angular/material/button";
import { HttpClientModule } from "@angular/common/http";
import { AccueilComponent } from "accueil/accueil.component";
import { LoginComponent } from "login/login.component";
import { ModulestudentComponent } from "modulestudent/modulestudent.component";
import { AutoevalComponent } from "autoeval/autoeval.component";
import { ModuleteacherComponent } from "moduleteacher/moduleteacher.component";
import { CreerquizzComponent } from "creerquizz/creerquizz.component";
import { ShowevalComponent } from "showeval/showeval.component";
import { ShowquizzComponent } from "showquizz/showquizz.component";
import { CommonModule } from "@angular/common";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AccueilComponent,
    LoginComponent, 
    ModulestudentComponent,
    AutoevalComponent,
    ModuleteacherComponent, 
    CreerquizzComponent,
    ShowevalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatListModule,
    FormsModule,
    MatIconModule,
    MatButtonModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
