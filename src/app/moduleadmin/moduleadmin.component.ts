import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../services/service.service';
import { Users, Modules } from 'models/model.model';

@Component({
  selector: 'moduleadmin',
  templateUrl: './moduleadmin.component.html',
  styleUrls: ['./moduleadmin.component.scss']
})
export class ModuleadminComponent implements OnInit {
  modules: Modules[] = [];
  users: Users[] = [];
  newModule: Modules = {major: '', description: '', idTeacher: 0 };
  newUser: Users = {
    name: '',
    surname: '',
    mail: '',
    password: '',
    role: 'student',
    major: ''
  };

  constructor(private service: Service, private router: Router) {}

  ngOnInit(): void {
    this.displayModules();
    this.displayUsers();
  }

  // Ajout d'un utilisateur
  addUser(): void {
    if (this.newUser.role === 'student' && !this.newUser.major) {
      console.error('La majeure doit être spécifiée pour un étudiant');
      return;
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
          major: ''
        };
        this.displayUsers();
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
        
        this.newModule = {major: '', description: '', idTeacher: 0 };
        this.displayModules();
      },
      (error) => {
        console.error('Erreur lors de l\'ajout du module:', error);
      }
    );
  }

  displayModules(): void {
    this.service.getAllModule().subscribe(
      (data:any) => {
        console.log("loading modules");
        this.modules = data;
      },
      (error: any) => {
          console.error('Erreur lors de la récupération des modules:', error);
      }
    )
  }

  displayUsers(): void {
    console.log("in display users");
    this.service.getAllUser().subscribe(
      (data:any) => {
        console.log("loading modules");
        this.users = data;
        console.log("loaded data : "+data);
      },
      (error: any) => {
          console.error('Erreur lors de la récupération des modules:', error);
      }
    )
  }

  deleteUser(idUser: number | undefined): void {
    console.log("in delete User");
    if (confirm("Voulez-vous vraiment supprimer cet utilisateur ?")) {
      this.service.deleteUserById(idUser).subscribe(
        (data:any) => {
          console.log("user deleted");
          this.displayUsers();
        },
        (error: any) => {
            console.error('Erreur lors de la récupération des modules:', error);
        }
      )
    }
  }

  deleteModule(idUser: number | undefined): void {
    console.log("in delete Module");
    if (confirm("Voulez-vous vraiment supprimer ce module ?")) {
      this.service.deleteModuleById(idUser).subscribe(
        (data:any) => {
          console.log("module deleted");
          this.displayModules();
        },
        (error: any) => {
            console.error('Erreur lors de la récupération des modules:', error);
        }
      )
    }
  }
}
