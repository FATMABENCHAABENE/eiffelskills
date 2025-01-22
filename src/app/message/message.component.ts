
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../services/service.service';
import { Users, Modules, Contact } from 'models/model.model';

@Component({
  selector: 'message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {
  contact: Contact[] = [];
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
    this.displayMessage();
  }

  
  displayMessage(): void {
    this.service.getallContact().subscribe(
      (data:any) => {
        console.log("loading modules");
        this.contact = data;
      },
      (error: any) => {
          console.error('Erreur lors de la récupération des modules:', error);
      }
    )
  }

  deletemessage(idcontact: number | undefined): void {
    console.log("in delete User");
    this.service.deletemessageById(idcontact).subscribe(
      (data:any) => {
        console.log("user deleted");
        this.displayMessage();
      },
      (error: any) => {
          console.error('Erreur lors de la récupération des modules:', error);
      }
    )
  }

}
