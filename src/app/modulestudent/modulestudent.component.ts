import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from "@angular/common/http";
import { Service } from '../services/service.service';
import { users, mat } from 'models/model.model';

@Component({
  selector: 'modulestudent',
  templateUrl: './modulestudent.component.html',
  styleUrl: './modulestudent.component.scss'
})
export class ModulestudentComponent implements OnInit {

  major: string = '';
  mat: mat[] =  [];

  constructor(private service: Service, private router: Router) { }

  ngOnInit(): void {
    this.major = this.service.getMajor();
    this.loadMat(this.major); 
  }

  showeval() {
    this.router.navigate(['/showeval']);
    }
    
  loadMat(major: string): void {
    console.log("Méthode loadmatières() appelée., je passe par là aussi ");
    this.service.getAllInfosMat(major).subscribe(
      (data: any[]) => {
        this.mat = data;
        console.log("ce que je reçois : ", data);
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  autoeval(arg0: any) {
    this.service.setModule(arg0);
    this.router.navigate(['/autoeval']);
    }

  
    quizz(arg0: any) {
    throw new Error('Method not implemented.');
    }

    ressources() {
      throw new Error('Method not implemented.');
      }

}

