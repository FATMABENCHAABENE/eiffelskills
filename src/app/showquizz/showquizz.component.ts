import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from "@angular/common/http";
import { Service } from '../services/service.service';
import { Users, mat, Modules, Qcm, AffQuizz } from 'models/model.model';

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
  questionsWithAnswers: { question: any; answers: any[]; }[] = [];

  constructor(private service: Service, private router: Router) { }

  ngOnInit(): void {
    this.idModule = this.service.getModule();
    this.loadquizz();
  }

  loadquizz() {
    console.log("ID du module que j'envoie au BACK :", this.idModule);
  
    this.service.getIdQCM(this.idModule).subscribe(
      (data: any[]) => {
        console.log("Ce que je reçois :", data);
  
        const idQCM = data[0].id;
  
        if (idQCM) {
          this.service.getQCM(idQCM).subscribe(
            (questions: any[] ) => {
              console.log("Les questions reçues :", questions);
  
              const questionWithAnswers: { question: any; answers: any[] }[] = [];
  
              const answerPromises = questions.map((question) => {
                console.log("id de la première question ", question.id);
  
                return this.service.getReponse(question.id).toPromise().then(
                  (answers: any[] | undefined) => {
                    // Vérifier si "answers" est défini avant de procéder
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
}
