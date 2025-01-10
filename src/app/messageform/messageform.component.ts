import { Component, OnInit } from '@angular/core';
import { Message } from '../models/home.model'
import { MessageService } from 'services/message.service';
import { AlertService } from 'services/alert.service';

@Component({
  selector: 'app-cv',
  templateUrl: './messageform.component.html',
  styleUrls: ['./messageform.component.scss']
})
/**
 * Class MessageFormComponent
 */
export class MessageFormComponent {
  surname: string = ''; name: string = ''; contact: string = ''; date: Date = new Date; messagebody: string = '';

  message: any[]|undefined;

  /**
   * Constructor
   * @param messageService 
   * @param alertService : Required to show a popup message
   */
  constructor(private messageService: MessageService, private alertService:AlertService) {}

  /**
   * Method sendMessage : If all form's field are filled, send the message to the back end's database
   */

  reset(): void {
    this.surname = '';
    this.name = '';
    this.contact = '';
    this.date = new Date(); // Réinitialisation de la date à la date actuelle
    this.messagebody = '';
  }
  
  sendMessage(): void {
    console.log("Message en cours d'envoi");
    if (this.surname=='' || this.name=='' || this.contact=='' || this.messagebody=='') {
      this.openAlert("Vous devez remplir tous les champs !");
    } else {
      const message: Message = {
        name: this.name, surname: this.surname, contact: this.contact, date: this.date, messagebody: this.messagebody
      }
      this.messageService.sendMessage(message).subscribe(
        (data: any[]) => {this.message = data;this.openAlert("Message envoyé");},
        (error: any) => {this.openAlert(error,);}
      );
      console.log("Message envoyé");
      this.reset();
    }
  }

  /**
   * Method openAlert
   * @param msg : Message to be shown
   */
  openAlert(msg:string) {
    this.alertService.displayAlert(msg);
  }

}

