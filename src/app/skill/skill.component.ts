
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../services/service.service';
import { Modules, Comp } from 'models/model.model';

@Component({
  selector: 'skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.scss']
})
export class SkillComponent implements OnInit {
  
    description: string = ''; 
    idMcq: number = 0; 
    reponseUn: string = '';
    reponseDeux: string = '';
    reponseTrois: string = '';
    reponseQuatre: string = ''; 
    questionstockee: string = ''; 
    idUserReponse: number = 0; 
    modules: Modules[] = [];
    reponsesRetournees: { id: number, description: string }[] = []; 
    responseMessage: any;
    id: number = 0;
    idSkill: number = 0;
    idmodule: number = 0; // ID du module à récupérer

    

    competences: any[] = []; // Liste des compétences
  
    constructor(private service: Service, private router: Router) { }

    ngOnInit(): void {
    
    this.idmodule = this.service.getModule();  
    console.log("ID du module sélectionné : ", this.idmodule);
    
    if (this.idmodule) {
      this.service.getmodulesbyID(this.idmodule).subscribe(
        (data: any) => {
          console.log('Modules reçus:', data);
          this.modules = data; // Stocker les données reçues
        },
        (error: any) => {
          console.error('Erreur lors de la récupération des modules:', error);
        }
      );
    } else {
      console.error('Aucun ID de module trouvé');
    }
      // Récupérer les compétences associées à ce module
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

    
    sendcomp(): void {
        const newSkill: Comp = {
    description: "",
    idModule: 0,
        };
        newSkill.idModule = this.idmodule;
        newSkill.description = this.description;
        console.log("Competence envoyée :", newSkill);
        // Envoi de la question au backend
        this.service.addSkill(newSkill)
          .subscribe(
            (data: any) => {
              // Stockage de la réponse dans une propriété locale
              this.responseMessage = data;  
              console.log('Réponse après l\'envoi:', this.responseMessage);
              // Réinitialisation du champ de saisie
              this.description = '';
            },
            error => {
              console.error("Erreur lors de l'envoi :", error);
            }
          );
      }

  }
