import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from "@angular/common/http";
import { Service } from '../services/service.service';
import { users, mat, Modules, Qcm, AffQuizz } from 'models/model.model';

@Component({
  selector: 'repondrequizz',
  templateUrl: './repondrequizz.component.html',
  styleUrl: './repondrequizz.component.scss'
})
export class RepondrequizzComponent implements OnInit{

  idModule: number = 0;
  constructor(private service: Service, private router: Router) { }

  ngOnInit(): void {
    this.idModule = this.service.getModule(); 
    console.log("nous sommes dans répondrequizz"); 
  }

}
