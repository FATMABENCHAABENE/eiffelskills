import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from "@angular/common/http";
import { Service } from '../services/service.service';
import { Users, mat, Modules, Qcm, Comp } from 'models/model.model';

@Component({
  selector: 'moduleteacher',
  templateUrl: './moduleteacher.component.html',
  styleUrl: './moduleteacher.component.scss'
})
export class ModuleteacherComponent implements OnInit {

  id: number = 0; 
  description: string = ''; 
  idModule: number = 0; 
  idMCQ: any[] | undefined; 
  is_good: boolean = false; 
  id_question: number = 0; 

  modules: Modules[] = [];
  qcm: Qcm[] = [];  
  responseMessage: any;
  constructor(private service: Service, private router: Router) { }

  ngOnInit(): void {
    this.id = this.service.getId()
    this.getmodulesbyID(this.id); 
  }

  getmodulesbyID(id: number) : void {
    this.service.getmodulesbyID(id).subscribe(
      (data: any) => {
          console.log('Modules reçus:', data);
          this.modules = data; // Stocker les données reçues
      },
      (error: any) => {
          console.error('Erreur lors de la récupération des modules:', error);
      }
  );
}

creerunquizz(arg1: string, arg0: any) {
  console.log("Création du QCM avec description :", arg1, "et module :", arg0);

  // Configurez le module
  this.service.setModule(arg0);

  // Préparez l'objet QCM
  const qcm: Qcm = {
    description: arg1,
    idModule: arg0
  };

  // Envoyez l'objet au backend
  this.service.sendidmodule(qcm)
    .subscribe(
      (data: any) => {
        
        this.responseMessage = data;
        console.log('Réponse retour du backend:', this.responseMessage);

        
        if (this.responseMessage.id) {
          console.log("ID du QCM reçu :", this.responseMessage.id);
          this.service.setMcq(this.responseMessage.id);
          this.router.navigate(['/creerquizz']);
        } else {
          console.error("L'ID du QCM est manquant dans la réponse :", this.responseMessage);
        }
      },
      error => {
        console.error("Erreur lors de l'envoi de la requête :", error);
      }
    );
}


showquizz(arg0: string,arg1: any) {
    this.service.setModule(arg1);
    this.router.navigate(['/showquizz']);
  }

showstudenteval(arg0: number | undefined, arg1: string) {
  //this.service.setModule(arg0);
  this.service.setMajor(arg1);

  // Exception pour signaler que la méthode n'est pas encore implémentée
  throw new Error('Méthode non implémentée : showstudenteval.');
}

gotoskill(modid: number | undefined ) {
  this.router.navigate(['/skill']);
  if (modid) {
    this.service.setModule(modid);
  }
}

gotoressource(id: number | undefined) {
  this.router.navigate(['/ressource']);
  if (id) {
    this.service.setModule(id);
  }
}
  
}
