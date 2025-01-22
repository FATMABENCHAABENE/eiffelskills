import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from "@angular/common/http";
import { Service } from '../services/service.service';
import { Users, mat, Modules, Qcm, AffQuizz } from 'models/model.model';

@Component({
  selector: 'repondrequizz',
  templateUrl: './repondrequizz.component.html',
  styleUrls: ['./repondrequizz.component.scss']
})
export class RepondrequizzComponent implements OnInit {

  idModule: number = 0;
  idStudent: number = 0; 
  questionsWithAnswers: { question: any; answers: any[] }[] = [];
  selectedAnswers: number[] = [];  // Liste des IDs des réponses sélectionnées

  constructor(private service: Service, private router: Router) { }

  ngOnInit(): void {
    this.idModule = this.service.getModule();
    this.idStudent = this.service.getId();  
    console.log("nous sommes dans répondrequizz et l'id du module est : ", this.idModule); 
    this.loadquizz(this.idModule); 
  }

  loadquizz(idModule: number) {
    console.log("ID du module que j'envoie au BACK :", idModule);

    this.service.getIdQCM(idModule).subscribe(
      (data: any[]) => {
        console.log("Ce que je reçois :", data);

        const idQCM = data[0].id;

        if (idQCM) {
          this.service.getQCM(idQCM).subscribe(
            (questions: any[]) => {
              console.log("Les questions reçues :", questions);

              const questionWithAnswers: { question: any; answers: any[] }[] = [];

              const answerPromises = questions.map((question) => {
                console.log("id de la première question ", question.id);

                return this.service.getReponse(question.id).toPromise().then(
                  (answers: any[] | undefined) => {
                    if (answers) {
                      console.log(`Réponses pour la question ${question.id} :`, answers);
                      questionWithAnswers.push({ question, answers });
                    } else {
                      console.warn(`Aucune réponse trouvée pour la question ${question.id}`);
                    }
                  },
                  (error: any) => {
                    console.error(`Erreur lors de la récupération des réponses pour la question ${question.id} :`, error);
                  }
                );
              });

              // Attendre que toutes les réponses soient récupérées
              Promise.all(answerPromises).then(() => {
                if (questionWithAnswers.length === questions.length) {
                  console.log("Toutes les questions avec leurs réponses :", questionWithAnswers);
                  this.questionsWithAnswers = questionWithAnswers;
                }
              });
            },
            (error: any) => {
              console.error("Erreur lors de la récupération des questions :", error);
            }
          );
        } else {
          console.error("ID QCM invalide reçu :", idQCM);
        }
      },
      (error: any) => {
        console.error("Erreur lors de la récupération de l'ID QCM :", error);
      }
    );
  }

  // Fonction pour ajouter une réponse sélectionnée à la liste
  onAnswerSelected(questionId: number, answerId: number) {
    // Vérifie si la réponse a déjà été sélectionnée pour cette question
    const existingAnswerIndex = this.selectedAnswers.indexOf(answerId);
    if (existingAnswerIndex === -1) {
      // Ajoute l'ID de la réponse à la liste si elle n'est pas déjà sélectionnée
      this.selectedAnswers.push(answerId);
    }
    console.log("Réponses sélectionnées :", this.selectedAnswers);
  }

  // Fonction pour envoyer les réponses sélectionnées
  sendAnswers() {
    console.log("Réponses envoyées :", this.selectedAnswers);
    this.service.envoyerProp(this.selectedAnswers, this.idStudent).subscribe(
      (response) => {
        console.log("Réponses envoyées avec succès", response);
      },
      (error) => {
        console.error("Erreur lors de l'envoi des réponses", error);
      }
    );
  }
}
