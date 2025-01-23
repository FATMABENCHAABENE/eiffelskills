import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../services/service.service';
import { Modules, Resource } from 'models/model.model';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'ressources',
  templateUrl: './ressources.component.html',
  styleUrls: ['./ressources.component.scss']
})
export class RessourcesComponent implements OnInit {
  resources: Resource[] = []; 
  newResource: Resource = {
    name: '',
    idmodule: 0
  };

  idmodule: number = 0;

  constructor(private service: Service, private router: Router) {}

  ngOnInit(): void {
    const moduleId = this.service.getModule(); // Récupérer l'ID depuis le service
    if (moduleId) {
      this.idmodule = moduleId;
      console.log('ID du module sélectionné :', this.idmodule);
      this.loadRessources(); // Charger les ressources
    } else {
      console.error('Aucun ID de module trouvé. Redirection vers la liste des modules.');
      this.router.navigate(['/']); // Redirige vers une autre page si aucun ID n'est défini
    }
  }
  

  loadRessources(): void {
    this.service.getRByModule(this.idmodule).subscribe(
      (data: Resource[]) => {
        this.resources = data;
        if (this.resources.length > 0) {
          console.log('Ressources récupérées avec succès :', this.resources);
        } else {
          console.log('Aucune ressource trouvée pour le module sélectionné.');
        }
      },
      (error) => {
        console.error('Erreur lors de la récupération des ressources :', error);
      }
    );
  }

  // Ajouter une ressource
  addRessource(): void {
    if (!this.newResource.name) {
      alert('Veuillez entrer un nom pour la ressource.');
      return;
    }

    const ressourceToAdd = { ...this.newResource, idModule: this.idmodule };
    this.service.addR(ressourceToAdd).subscribe(
      (response) => {
        console.log('Nouvelle ressource ajoutée :', response);
        this.newResource.name = ''; 
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
