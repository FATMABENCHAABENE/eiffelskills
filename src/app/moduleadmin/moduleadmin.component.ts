import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../services/service.service';
import { users, Modules } from 'models/model.model';

@Component({
  selector: 'moduleadmin',
  templateUrl: './moduleadmin.component.html',
  styleUrls: ['./moduleadmin.component.scss']
})
export class ModuleadminComponent implements OnInit {
  modules: Modules[] = [];
  newModule: Modules = { id: 0, major: '', description: '', id_teacher: 0 };
  newUser: users = {
    name: '',
    surname: '',
    mail: '',
    password: '',
    role: 'student',
    major: '' 
  };

  constructor(private service: Service, private router: Router) {}

  ngOnInit(): void {
   
  }

  // Ajout d'un utilisateur
  addUser(): void {
    if (this.newUser.role === 'student' && !this.newUser.major) {
      console.error('La majeure doit être spécifiée pour un étudiant');
      return; // Empêche l'ajout de l'utilisateur si major est vide
    }

    this.service.addUser(this.newUser).subscribe(
      (response) => {
        console.log('Utilisateur ajouté avec succès:', response);
        this.newUser = {
          name: '',
          surname: '',
          mail: '',
          password: '',
          role: 'student',
          major: '',
        };
      },
      (error) => {
        console.error('Erreur lors de l\'ajout de l\'utilisateur:', error);
      }
    );
  }

  // Ajout d'un module
  addModule(): void {
    this.service.addModule(this.newModule).subscribe(
      (response) => {
        console.log('Module ajouté avec succès:', response);
        // Réinitialisation des champs
        this.newModule = { id: 0, major: '', description: '', id_teacher: 0 };
      },
      (error) => {
        console.error('Erreur lors de l\'ajout du module:', error);
      }
    );
  }
}
