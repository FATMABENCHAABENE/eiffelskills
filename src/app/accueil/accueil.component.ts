import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../services/service.service';

@Component({
  selector: 'accueil',
  templateUrl: './accueil.component.html',
  styleUrl: './accueil.component.scss'
})

export class AccueilComponent implements OnInit {
  // Déclarations des variables
  constructor(private service: Service, private router: Router) { }
  ngOnInit(): void {
  }

  selogin(value : number) : void {
    this.service.setLoginIn(value);
    this.router.navigate(['/login']);
  } 
  
}