import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../services/service.service';

@Component({
  selector: 'accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent implements OnInit {

  candidateId: number = 0;
  isHelpMenuVisible: boolean = false; // État pour afficher ou masquer le menu

  constructor(private service: Service, private router: Router) { }

  ngOnInit(): void { }

  selogin(value: number): void {
    this.service.setLoginIn(value);
    this.router.navigate(['/login']);
  }

  loadevalrecrut() {
    this.service.setId(this.candidateId);
    this.router.navigate(['/showeval']);
  }

  // Bascule l'état du menu d'aide
  toggleHelpMenu(): void {
    this.isHelpMenuVisible = !this.isHelpMenuVisible;
  }
}
