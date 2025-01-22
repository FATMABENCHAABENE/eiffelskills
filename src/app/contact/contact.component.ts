import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../services/service.service';
import { Contact } from 'models/model.model';

@Component({
  selector: 'contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {
  contact: Contact = {
    name: '',
    surname: '',
    mail: '',
    message: ''
  };

  constructor(private service: Service, private router: Router) {}

  ngOnInit(): void {
    // Initialisation si nécessaire
  }

  envoyerFormulaire(): void {
    this.service.sendContact(this.contact).subscribe({
      next: () => {
        alert('Votre message a été envoyé avec succès !');
        this.router.navigate(['/merci']); // Redirection vers une page de confirmation
      },
      error: () => {
        console.error('Erreur lors de l\'envoi du message');
        alert('Une erreur est survenue. Veuillez réessayer plus tard.');
      }
    });
  }
}

