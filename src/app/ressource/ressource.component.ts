import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../services/service.service';
import { Modules, Ressource } from 'models/model.model';

@Component({
  selector: 'ressource',
  templateUrl: './ressource.component.html',
  styleUrls: ['./ressource.component.scss']
})
export class RessourceComponent implements OnInit {
  ressources: Ressource[] = []; 
  newRessource: Ressource = {
    name: '',
    idmodule: 0
  };

  idmodule: number = 0;

  constructor(private service: Service, private router: Router) {}

  ngOnInit(): void {
    this.idmodule = this.service.getModule();
    console.log('ID du module sélectionné :', this.idmodule);
    if (this.idmodule) {
      this.loadRessources();
    } else {
      console.error('Aucun ID de module trouvé');
    }
  }

  // Charger les ressources associées au module
  loadRessources(): void {
    this.service.getRByModule(this.idmodule).subscribe(
      (data: Ressource[]) => {
        this.ressources = data;
        console.log('Ressources récupérées :', this.ressources);
      },
      (error) => {
        console.error('Erreur lors de la récupération des ressources :', error);
      }
    );
  }

  // Ajouter une ressource
  addRessource(): void {
    if (!this.newRessource.name) {
      alert('Veuillez entrer un nom pour la ressource.');
      return;
    }

    const ressourceToAdd = { ...this.newRessource, idModule: this.idmodule };
    this.service.addR(ressourceToAdd).subscribe(
      (response) => {
        console.log('Nouvelle ressource ajoutée :', response);
        this.newRessource.name = ''; 
        this.loadRessources(); 
      },
      (error) => {
        console.error('Erreur lors de l\'ajout de la ressource :', error);
      }
    );
  }

  // Supprimer une ressource
  deleteRessource(idRessource: number | undefined): void {
    if (confirm('Êtes-vous sûr de vouloir supprimer cette ressource ?')) {
      this.service.deleteR(idRessource).subscribe(
        (response) => {
          console.log('Ressource supprimée avec succès :', response);
          this.loadRessources(); 
        },
        (error) => {
          console.error('Erreur lors de la suppression de la ressource :', error);
        }
      );
    }
  }
}
