import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../services/service.service';
import { Question } from 'models/model.model';

@Component({
  selector: 'creerquizz',
  templateUrl: './creerquizz.component.html',
  styleUrls: ['./creerquizz.component.scss']
})
export class CreerquizzComponent implements OnInit {

  description: string = ''; 
  idMcq: number = 0; 
  reponseUn: string = '';
  reponseDeux: string = '';
  reponseTrois: string = '';
  reponseQuatre: string = ''; 
  questionstockee: string = ''; 
  idUserReponse: number = 0; 

  question: Question[] = []; 
  reponsesRetournees: { id: number, description: string }[] = []; 
  responseMessage: any;
  id: number = 0;
  idSkill: number = 0;
  idmodule: number = 1; // ID du module à récupérer

  competences: any[] = []; // Liste des compétences

  constructor(private service: Service, private router: Router) { }

  ngOnInit(): void {
    this.idMcq = this.service.getMcq(); 
    console.log("L'ID du QCM récupéré est", this.idMcq);

    // Exemple pour récupérer les compétences en fonction du module
      this.service.getCompetencesByModule(this.idmodule).subscribe(
        (data: any[]) => {
          this.competences = data;
          console.log("Compétences récupérées : ", this.competences);
        },
        (error) => {
          console.error("Erreur lors de la récupération des compétences : ", error);
        }
      );
  }

  sendquestion() {
    const newQuestion: Question = {
      description: this.description,
      idMcq: this.idMcq,
      idSkill: this.idSkill,  // Utilisation de l'ID de la compétence sélectionnée
    };

    console.log("Question envoyée :", newQuestion);

    // Envoi de la question au backend
    this.service.sendQuestion(newQuestion)
      .subscribe(
        (data: any) => {
          // Stockage de la réponse dans une propriété locale
          this.responseMessage = data;  
          console.log('Réponse après l\'envoi de la question:', this.responseMessage);

          // Vérification et affichage de l'ID reçu
          if (this.responseMessage.id) {
            console.log("ID de la question reçue :", this.responseMessage.id);
            this.service.setIdquestion(this.responseMessage.id); 
            this.questionstockee = this.responseMessage.description; 
          } else {
            console.error("L'ID est manquant dans la réponse :", this.responseMessage);
          }

          // Réinitialisation du champ de saisie
          this.description = '';
        },
        error => {
          console.error("Erreur lors de l'envoi de la question :", error);
        }
      );
  }

  envoyereponse() {
    // Créer une liste des réponses
    const reponses = [
      this.reponseUn,
      this.reponseDeux,
      this.reponseTrois,
      this.reponseQuatre
    ];

    this.id = this.service.getIdquestion();
    this.service.envoyerRep(this.id, reponses).subscribe(
      (response) => {
        console.log('Réponse du back après envoi des quatres réponses', response);

        // Stocker les id et description dans un tableau
        this.reponsesRetournees = response.map((item: { id: number, description: string }) => ({
          id: item.id,
          description: item.description
        }));

        console.log("Tableau des réponses retournées:", this.reponsesRetournees);
      },
      (error) => {
        console.error('Erreur lors de l\'envoi des quatres réponses possibles:', error);
      }
    );
  }

  envoyeBreponse(id: number) {
    this.service.envoyerBRep(id)
      .subscribe(
        response => {
          console.log('Réponse du back après envoi de la bonne réponse', response);
        },
        error => {
          console.error('Erreur lors de l\'envoi de la nouvelle réponse:', error);
        }
      );
  }
}
