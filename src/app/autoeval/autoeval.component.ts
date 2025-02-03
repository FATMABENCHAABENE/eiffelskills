import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from "@angular/common/http";
import { Service } from '../services/service.service';
import { Users, mat, Comp, Eval } from 'models/model.model';

@Component({
  selector: 'autoeval',
  templateUrl: './autoeval.component.html',
  styleUrl: './autoeval.component.scss'
})
export class AutoevalComponent implements OnInit{

  id: number = 0;
  module: number = 0;  
  id_skill: number = 0; 
  id_student: number = 0; 
  eval: string = ''; 
  quizzEval: string = ''; 
  comp: Comp[] = [];
  evaluation: Eval[] = []; 

  constructor(private service: Service, private router: Router) { }

  ngOnInit(): void {
    this.module = this.service.getModule();
    this.id = this.service.getId(); 
    this.loadinfoComp(this.module);
  }

  loadinfoComp(module: number): void {
    this.service.getAllInfosComp(module).subscribe(
      (data: Comp[]) => {
        this.comp = data;
        console.log("voici les compétences que je reçois :", data);
      },
      (error: any) => {
        console.log("Erreur lors du chargement des informations personnelles :", error);
      }
    );
  }

  updateeval(idskill: number | undefined, value_skill: string): void {
    if (idskill === undefined) {
      console.error("L'ID de compétence est undefined !");
      return; 
    }
    console.log("La valeur = ", value_skill);
    this.id_skill = idskill;
  
    const evaluation: Eval = {
      idSkill: this.id_skill, 
      idStudent: this.id,
      eval: value_skill,
      quizzEval: "non évalué",
    };  
    console.log("Évaluation créée :", evaluation);

    this.service.updateval(evaluation).subscribe(
      (data: any) => {
        console.log('Infos enregistrées avec succès pour l auto eval!', data);
      },
      (error: any) => {
        console.log('Erreur lors de l\'enregistrement des infos : ', error);
      }
    );
  }

}
