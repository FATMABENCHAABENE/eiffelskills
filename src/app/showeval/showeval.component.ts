import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from "@angular/common/http";
import { Service } from '../services/service.service';
import { users, mat, Affichage } from 'models/model.model';

@Component({
  selector: 'showeval',
  templateUrl: './showeval.component.html',
  styleUrl: './showeval.component.scss'
})
export class ShowevalComponent implements OnInit{

  id: number = 0; 
  eval: string = ''; 
  quizzEval: string = ''; 
  idSkill: number = 0; 
  response: any; 
  index: any;
  description : string = ''; 
  responseLib: any;
  responseMessage : Affichage[] = []; 

  constructor(private service: Service, private router: Router) { }

  ngOnInit(): void {
    this.id = this.service.getId(); 
    this.loadAutoEval(this.id); 
  }

  loadAutoEval(id: number): void {
    this.service.getAllEvals(id).subscribe(
      (data: any[]) => {
        console.log("Ce que je reçois pour loadEval() : ", data);

        // Réinitialiser la réponse pour stocker les données sous le format Affichage
        this.responseMessage = [];

        // Parcourir les évaluations reçues
        data.forEach((response: { idSkill: number; eval: string; quizzEval: string }) => {
          const newAffichage: Affichage = {
            idSkill: response.idSkill,
            eval: response.eval,
            quizzeval: response.quizzEval,
            description: 'Chargement...'  // Valeur initiale avant la récupération de la description
          };

          // Récupérer la description pour chaque idSkill
          if (response.idSkill) {
            this.service.getLibelle(response.idSkill).subscribe(
              (mat: any) => {
                newAffichage.description = mat?.description || 'Description indisponible'; // On met à jour la description
                this.responseMessage.push(newAffichage);  // Ajoutez l'élément à la réponse
                console.log(`Libellé pour idSkill ${response.idSkill} :`, mat);
              },
              (error: any) => {
                console.error(`Erreur lors de la récupération du libellé pour idSkill ${response.idSkill} :`, error);
                newAffichage.description = 'Erreur de récupération'; // Si erreur, ajouter un message d'erreur
                this.responseMessage.push(newAffichage);  // Ajoutez l'élément avec un message d'erreur
              }
            );
          } else {
            console.warn(`idSkill manquant pour l'évaluation.`);
            newAffichage.description = 'ID Skill manquant'; // Si pas d'idSkill, ajouter un message
            this.responseMessage.push(newAffichage);  // Ajoutez l'élément sans description
          }
        });
      },
      (error: any) => {
        console.error("Erreur lors de la récupération des évaluations :", error);
      }
    );
  }

  
}
