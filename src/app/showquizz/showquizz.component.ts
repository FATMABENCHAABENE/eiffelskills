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

  /*
  loadquizz() {
    console.log("ID du module que j'envoie au BACK :", this.idModule);
  
    // Appel à la méthode du service pour obtenir les données du QCM
    this.service.getIdQCM(this.idModule).subscribe(
      (data: { id: number; description: string; idModule: number }) => {
        console.log("Données reçues de getIdQCM :", data);
  
        // Créer un tableau pour afficher les questions et réponses
        let newAffichage: any[] = [];
  
        // Vérifier que l'ID de la question existe
        if (data && data.id) {
          console.log("L'id du QCM est ", data.id);
  
          // Récupérer les détails des questions du QCM via le service
          this.service.getQCM(data.id).subscribe(
            (questions: { id: number; description: string; idMcq: number; idSkill: number }[]) => {
              console.log("Données récupérées pour l'ID du QCM :", questions);
  
              // Vérifier si le tableau contient des questions
              if (questions && questions.length > 0) {
                // Itérer sur chaque question récupérée
                questions.forEach((question) => {
                  const questionAffichage: any = {
                    id: question.id,
                    descriptionMod: data.description,
                    question: question.description,  // La question récupérée
                    reponseUn: '',  // Réponse 1
                    reponseDeux: '',  // Réponse 2
                    reponseTrois: '',  // Réponse 3
                    reponseQuatre: '',  // Réponse 4
                    is_goodUn: false,  // Indicateur pour la réponse 1
                    is_goodDeux: false,  // Indicateur pour la réponse 2
                    is_goodTrois: false,  // Indicateur pour la réponse 3
                    is_goodQuatre: false,  // Indicateur pour la réponse 4
                  };
  
                  // Ajouter cette question au tableau newAffichage
                  newAffichage.push(questionAffichage);
  
                  // Récupérer les réponses de la question
                  this.service.getReponse(question.id).subscribe(
                    (lot: any) => {
                      console.log("Les réponses pour la question ", question.id, " : ", lot);
  
                      // Vérifier que nous avons bien 4 réponses pour chaque question
                      if (lot && lot.length === 4) {
                        let index = 1;  // Variable pour suivre la réponse à ajouter
  
                        // Itérer sur les réponses et les assigner
                        lot.forEach((response: { description: any; good: any; }) => {
                          if (index === 1) {
                            questionAffichage.reponseUn = response.description;
                            questionAffichage.is_goodUn = response.good;
                          } else if (index === 2) {
                            questionAffichage.reponseDeux = response.description;
                            questionAffichage.is_goodDeux = response.good;
                          } else if (index === 3) {
                            questionAffichage.reponseTrois = response.description;
                            questionAffichage.is_goodTrois = response.good;
                          } else if (index === 4) {
                            questionAffichage.reponseQuatre = response.description;
                            questionAffichage.is_goodQuatre = response.good;
                          }
                          index++;
                        });
  
                        // Rafraîchir l'affichage de toutes les questions et réponses
                        this.responseMessage = [...newAffichage];
                      } else {
                        console.error("Erreur : Les réponses pour la question n'ont pas été reçues correctement");
                      }
                    },
                    (error) => {
                      console.error("Erreur lors de la récupération des réponses pour la question ", question.id, " : ", error);
                    }
                  );
                });
  
              } else {
                console.log("Aucune question trouvée pour ce QCM.");
              }
            },
            (error) => {
              console.error("Erreur lors de la récupération des données des questions du QCM :", error);
            }
          );
        } else {
          console.error("Erreur : ID du QCM invalide ou manquant");
        }
      },
      (error) => {
        console.error("Erreur lors de la récupération des données du QCM :", error);
      }
    );
  }*/
 
  
  
}
