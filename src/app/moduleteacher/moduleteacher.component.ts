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

  newSkill: Comp = {
    description: '', 
    idmodule: 0,
  };
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
        // Stockez la réponse dans une propriété
        this.responseMessage = data;
        console.log('Réponse retour du backend:', this.responseMessage);

        // Vérifiez et affichez l'ID du QCM
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

addSkill(moduleId: number | undefined): void {
  if (!moduleId) {
    console.error('Erreur : l\'ID du module est indéfini.');
    return;
  }

  if (!this.newSkill || !this.newSkill.description) {
    console.error('Erreur : la description de la compétence est vide.');
    return;
  }

  this.newSkill.idmodule = moduleId; // Associe l'ID du module à la compétence

  this.service.addSkill(this.newSkill).subscribe(
    (response) => {
      console.log('Compétence ajoutée avec succès :', response);
      // Réinitialisation des champs
      this.newSkill = { id: 0, description: '', idmodule: 0 };
    },
    (error) => {
      console.error('Erreur lors de l\'ajout de la compétence :', error);
    }
  );

}
}
