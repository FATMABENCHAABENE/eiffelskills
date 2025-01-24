import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Users, Modules} from 'models/model.model';
import { Service } from 'services/service.service';

@Component({
  selector: 'teachershoweval',
  templateUrl: './teachershoweval.component.html',
  styleUrl: './teachershoweval.component.scss'
})
export class TeachershowevalComponent implements OnInit {
  major: string="";
  id: number = 0;
  users: Users[]=[];
  module : Modules[]=[];
  idmodule: number = 0;
  constructor(private service: Service, private router: Router) { }

  ngOnInit(): void {
    // Récupération de l'ID du major
    this.major = this.service.getMajor();
    console.log('ID du major : ', this.major);

    const moduleId = this.service.getModule(); 
    if (moduleId) {
      this.idmodule = moduleId;
      console.log('ID du module sélectionné :', this.idmodule);
    }
   // Charger les utilisateurs associés au major
    if (this.major) {
      this.getUsersByMajor();
    } else {
      console.error('Aucun ID de major trouvé');
    }
  }

  getUsersByMajor() {
    this.service.getUserbyMat(this.major).subscribe(
      (data: any[]) => {
        this.users = data;
        console.log('Utilisateurs récupérés : ', this.users);
      },
      (error: any) => {
        console.error('Erreur lors de la récupération des utilisateurs : ', error);
      }
    );
  }

}

