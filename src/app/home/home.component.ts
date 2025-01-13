import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { CvService } from '../services/home.service';
import { Infos } from '../models/home.model';
import { Diplome } from '../models/home.model';
import { ExPro } from '../models/home.model';
import { Skills } from '../models/home.model';
import { Certif } from '../models/home.model';
import { Hobbie } from '../models/home.model';
import { Contact } from '../models/home.model';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';  // Pour utiliser les directives de base comme ngIf, ngFor
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,  // Pour les directives de base Angular
    ReactiveFormsModule,

  ],
  exports: []  // Exporte le composant si nécessaire
})
export class HomeModule { }

@Component({
  selector: "home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.scss"],
})

export class HomeComponent implements OnInit {
  nom: string = "";
  prenom: string = "";
  infos: Infos[] = [];
  diplomes: Diplome[] = [];
  expro: ExPro[] = [];
  skills: Skills[] = [];
  certif: Certif[] = [];
  hobbie: Hobbie[] = [];
  contact: Contact[] = [];

  constructor(private cvService: CvService) {}

  ngOnInit(): void {
     // Appel des méthodes pour charger les données lors de l'initialisation du composant
     this.loadInfos();
     this.loadDiplomes();
     this.loadExPro();
     this.loadSkills();
     this.loadCertif();
     this.loadHobbie();
     this.loadContact();
  }

  loadInfos(): void {
    console.log("Méthode loadInfos() appelée.");
    this.cvService.getAllInfos().subscribe(
      (data: any[]) => {
        this.infos = data;
      },
      (error: any) => {
        console.log(error,'Erreur d\affichage');
      }
    );
  }

  loadDiplomes(): void {
    console.log("Méthode loadDiplomes() appelée.");
    this.cvService.getAllDiplomes().subscribe(
      (data: Diplome[]) => {
        this.diplomes = data;
      },
      (error: any) => {
        console.log(error,'Erreur d\affichage');
      }
    );
  }

  loadExPro(): void {
    console.log("Méthode loadDiplomes() appelée.");
    this.cvService.getAllExPro().subscribe(
      (data: ExPro[]) => {
        this.expro = data;
      },
      (error: any) => {
        console.log(error,'Erreur d\affichage');
      }
    );
  }

  loadSkills(): void {
    console.log("Méthode loadDiplomes() appelée.");
    this.cvService.getAllSkills().subscribe(
      (data: Skills[]) => {
        this.skills = data;
      },
      (error: any) => {
        console.log(error,'Erreur d\affichage');
      }
    );
  }

  loadCertif(): void {
    console.log("Méthode loadDiplomes() appelée.");
    this.cvService.getAllCertif().subscribe(
      (data: Certif[]) => {
        this.certif = data;
      },
      (error: any) => {
        console.log(error,'Erreur d\affichage');
      }
    );
  }

  loadHobbie(): void {
    console.log("Méthode loadHobbie() appelée.");
    this.cvService.getAllHobbie().subscribe(
      (data: Hobbie[]) => {
        this.hobbie = data;
      },
      (error: any) => {
        console.log(error,'Erreur d\affichage');
      }
    );
  }

  loadContact(): void {
    console.log("Méthode loadHobbie() appelée.");
    this.cvService.getAllContact().subscribe(
      (data: Contact[]) => {
        this.contact = data;
      },
      (error: any) => {
        console.log(error,'Erreur d\affichage');
      }
    );
  }
}

