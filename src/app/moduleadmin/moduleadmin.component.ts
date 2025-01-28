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
  messages: string[] = []; // Mock messages for demonstration
  newModule: Modules = { major: '', description: '', idTeacher: 0 };
  newUser: Users = {
    name: '',
    surname: '',
    mail: '',
    password: '',
    role: 'student',
    major: ''
  };

  activeSection: string = 'users'; // Default section is "users"
  isSidebarVisible: boolean = true; // Track sidebar visibility

  constructor(private service: Service, private router: Router) {}

  ngOnInit(): void {
    this.displayModules();
    this.displayUsers();
    this.loadMessages(); // Load messages on initialization
  }

  // Toggle sidebar visibility
  toggleDashboard(): void {
    this.isSidebarVisible = !this.isSidebarVisible;
  }

  // Switch sections
  showSection(section: string): void {
    this.activeSection = section;
  }

  // Navigate to the "Messagerie" section
  gotomessage(): void {
    this.activeSection = 'messages'; // Switch the active section to "messages"
  }

  // Load messages (mock implementation)
  loadMessages(): void {
    this.messages = [
      'Bienvenue sur le tableau de bord admin',
      'Votre dernier utilisateur a été ajouté avec succès.',
      'Un module a été mis à jour.'
    ];
  }

  // Add a new user
  addUser(): void {
    if (this.newUser.role === 'student' && !this.newUser.major) {
      console.error('La majeure doit être spécifiée pour un étudiant');
      return;
    }

    this.service.addUser(this.newUser).subscribe(
      () => {
        this.newUser = { name: '', surname: '', mail: '', password: '', role: 'student', major: '' };
        this.displayUsers(); // Refresh the users list
      },
      (error) => console.error('Erreur lors de l\'ajout de l\'utilisateur:', error)
    );
  }

  // Add a new module
  addModule(): void {
    this.service.addModule(this.newModule).subscribe(
      () => {
        this.newModule = { major: '', description: '', idTeacher: 0 };
        this.displayModules(); // Refresh the modules list
      },
      (error) => console.error('Erreur lors de l\'ajout du module:', error)
    );
  }

  // Fetch all modules
  displayModules(): void {
    this.service.getAllModule().subscribe(
      (data: Modules[]) => (this.modules = data),
      (error) => console.error('Erreur lors de la récupération des modules:', error)
    );
  }

  // Fetch all users
  displayUsers(): void {
    this.service.getAllUser().subscribe(
      (data: Users[]) => (this.users = data),
      (error) => console.error('Erreur lors de la récupération des utilisateurs:', error)
    );
  }

  // Delete a user
  deleteUser(idUser: number | undefined): void {
    if (!idUser) return;
    if (confirm('Voulez-vous vraiment supprimer cet utilisateur ?')) {
      this.service.deleteUserById(idUser).subscribe(
        () => this.displayUsers(), // Refresh the users list
        (error) => console.error('Erreur lors de la suppression de l\'utilisateur:', error)
      );
    }
  }

  // Delete a module
  deleteModule(idModule: number | undefined): void {
    if (!idModule) return;
    if (confirm('Voulez-vous vraiment supprimer ce module ?')) {
      this.service.deleteModuleById(idModule).subscribe(
        () => this.displayModules(), // Refresh the modules list
        (error) => console.error('Erreur lors de la suppression du module:', error)
      );
    }
  }
}
