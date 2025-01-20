import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from "@angular/common/http";
import { Service } from '../services/service.service';
import { users, mat, Modules, Qcm, AffQuizz } from 'models/model.model';

@Component({
  selector: 'showquizz',
  templateUrl: './showquizz.component.html',
  styleUrl: './showquizz.component.scss'
})
export class ShowquizzComponent implements OnInit {

  idModule: number = 0;
  id: number = 0;
  descriptionMod: string = ''; 
  reponseUn: string = ''; 
  reponseDeux: string = ''; 
  reponseTrois: string = '';
  responseQuatre: string = ''; 
  is_good: boolean = false; 
  responseMessage : AffQuizz[] = []; 

  constructor(private service: Service, private router: Router) { }

  ngOnInit(): void {
    this.idModule = this.service.getModule();
    this.loadquizz(); 
  }




  loadquizz() {
    console.log("ID du module que j'envoie au BACK", this.idModule);
  
    // Appel à la méthode du service pour obtenir les données du QCM
    this.service.getIdQCM(this.idModule).subscribe(
      (data: any) => {
        console.log("je suis ici et voici Ce que je reçois pour loadquizz() : ", data);

        // Initialisation de responseMessage
        this.responseMessage = [];
  
        // Vérification si data est un tableau ou un objet
        if (Array.isArray(data)) {
          // Si data est un tableau, itérer dessus
          data.forEach((response: { id: number; description: string }) => {
           
  
            // Création d'un nouvel objet AffQuizz
            const newAffichage: AffQuizz = {
              id: response.id,
              descriptionMod: response.description,
              reponseUn: 'Chargement...',
              reponseDeux: 'Chargement...',
              reponseTrois: 'Chargement...',
              reponseQuatre: 'Chargement...',
              is_good: false,
            };
  
            // Envoi de l'ID du QCM pour récupérer plus de données
            this.service.getQCM(1).subscribe(
              (mat: any) => {
                console.log("Ce que je récupère après l'envoi de l'ID du QCM :", mat);
  
                // Mise à jour de l'objet avec la réponse reçue
                // On met à jour les réponses du QCM ici
                newAffichage.reponseUn = mat.reponseUn || 'Chargement...';
                newAffichage.reponseDeux = mat.reponseDeux || 'Chargement...';
                newAffichage.reponseTrois = mat.reponseTrois || 'Chargement...';
                newAffichage.reponseQuatre = mat.reponseQuatre || 'Chargement...';
  
                // Ajout de l'objet à responseMessage
                this.responseMessage.push(newAffichage);
              },
              (error) => {
                console.error("Erreur lors de la récupération des données supplémentaires du QCM :", error);
              }
            );
          });
        } else if (data && !Array.isArray(data)) {
          // Si data est un objet, nous l'utilisons directement
          const response: { id: number; description: string } = data;
  
          // Création d'un nouvel objet AffQuizz
          const newAffichage: AffQuizz = {
            id: response.id,
            descriptionMod: response.description,
            reponseUn: 'Chargement...',
            reponseDeux: 'Chargement...',
            reponseTrois: 'Chargement...',
            reponseQuatre: 'Chargement...',
            is_good: false,
          };
  
          // Ajout de l'objet à responseMessage
          this.responseMessage = [newAffichage];
  
          // Si nécessaire, récupérer des données supplémentaires en utilisant l'ID
          this.service.getQCM(1).subscribe(
            (mat: any) => {
              console.log("Ce que je récupère après l'envoi de l'ID du QCM :", mat);
  
              // Mise à jour de l'objet avec la réponse reçue
            //  newAffichage.reponseUn = mat.reponseUn || 'Chargement...';
              //newAffichage.reponseDeux = mat.reponseDeux || 'Chargement...';
              //newAffichage.reponseTrois = mat.reponseTrois || 'Chargement...';
              //newAffichage.reponseQuatre = mat.reponseQuatre || 'Chargement...';
            },
            (error) => {
              console.error("Erreur lors de la récupération des données supplémentaires du QCM :", error);
            }
          );
        } else {
          console.error("Format de données inattendu :", data);
        }
      },
      (error) => {
        console.error("Erreur lors de la récupération des données du quiz :", error);
      }
    );
  }
  
  
}
