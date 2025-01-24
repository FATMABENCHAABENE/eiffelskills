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
import { RepondrequizzComponent } from "repondrequizz/repondrequizz.component";
import { ModuleadminComponent } from "moduleadmin/moduleadmin.component";
import { CommonModule } from "@angular/common";
import { ContactComponent } from "contact/contact.component";
import {SkillComponent} from "skill/skill.component";
import {MessageComponent} from "message/message.component";
import {RessourceComponent} from "ressource/ressource.component";
import {RessourcesComponent} from "ressources/ressources.component";
import {TeachershowevalComponent} from "teachershoweval/teachershoweval.component";

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
    ShowevalComponent, 
    ShowquizzComponent, 
    RepondrequizzComponent,
    ModuleadminComponent,
    ContactComponent,
    SkillComponent,
    MessageComponent,
    RessourceComponent,
    RessourcesComponent,
    TeachershowevalComponent,
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


