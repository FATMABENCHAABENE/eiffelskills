import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  mail: string = "";
  password: string = "";

  constructor() {}

  ngOnInit(): void {}

  seConnecter(): void {
    console.log('Mail :', this.mail);
    console.log('Password :', this.password);
    // Logique de connexion ici (par exemple, appel à un service)
  }
}
