import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Users, Modules, Comp, Eval} from 'models/model.model';
import { Service } from 'services/service.service';

@Component({
  selector: 'teachershoweval',
  templateUrl: './teachershoweval.component.html',
  styleUrl: './teachershoweval.component.scss'
})
export class TeachershowevalComponent implements OnInit {
  major: string="";
  id: number = 0;
  idSkill: number[] = [];
  res: Eval[]=[];
  users: Users[]=[];
  compe: Comp[]=[];
  module : Modules[]=[];
  idmodule: number = 0;
  constructor(private service: Service, private router: Router) { }

  ngOnInit(): void {
    // Récupération de l'ID du major
    this.major = this.service.getMajor();
    console.log('ID du major : ', this.major);
    const moduleId = this.service.getModule();
    if (moduleId) {
      this.idmodule = moduleId;
      this.getcomp();
      console.log('ID du module sélectionné :', this.idmodule);
    }
   // Charger les utilisateurs associés au major
    if (this.major) {
      this.getUsersByMajor();
    } else {
      console.error('Aucun ID de major trouvé');
    }
  }
  
  getcomp(){
    this.service.getAllInfosComp(this.idmodule).subscribe(
      (data: any[

      ]) => {
        this.compe = data;
        console.log('Competences : ', this.compe);
      },
      (error: any) => {
        console.error('Erreur lors de la récupération des utilisateurs : ', error);
      }
    );
    }
    updateSkill(event: Event): void {
      const target = event.target as HTMLSelectElement;
      if (target) {
        const selectedSkill = Number(target.value);
        this.idSkill=[];
        this.idSkill.push(selectedSkill);
        // Vérifier si la compétence est déjà dans la liste
        /*if (!this.idSkill.includes(selectedSkill)) {
          // Ajouter la compétence au tableau si elle n'y est pas encore
          this.idSkill=[];
          this.idSkill.push(selectedSkill);
        } else {
          // Sinon, retirer la compétence du tableau
          this.idSkill = this.idSkill.filter(skill => skill !== selectedSkill);
        }*/
      } else {
        console.error('Impossible de récupérer la sélection.');
      }
    }
    
  getUsersByMajor() {
    this.service.getUserbyMat(this.major).subscribe(
      (data: any[]) => {
        this.users = data;
        console.log('Utilisateurs récupérés : ', this.users);
      },
      (error: any) => {
        console.error('Erreur lors de la récupération des utilisateurs : ', error);
      }
    );
  }

  sendid(idStudent: number | undefined): void {
    if (idStudent === undefined || this.idSkill.length === 0) {
      console.error('L\'ID étudiant ou l\'ID compétence est invalide.');
      return;
    }
    console.log()
    // Appel au service pour envoyer les données
    this.service.postid(idStudent, this.idSkill).subscribe(
      (res: Eval[]) => { 
        console.log('Réponse reçue du serveur :', res);
        this.res=[];
        this.res.push(...res); 
      },
      (error: any) => {
        console.error('Erreur lors de l\'envoi de la requête :', error);
      }
    );
  }
  
  
}

