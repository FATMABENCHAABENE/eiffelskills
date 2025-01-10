import { Component, OnInit } from '@angular/core';
import { Message } from '../models/home.model'
import { MessageService } from 'services/message.service';
import { AlertService } from 'services/alert.service';

@Component({
    selector: 'app-cv',
    templateUrl: 'inbox.component.html',
    styleUrl: 'inbox.component.scss'
})

/**
 * Class InboxComponent
 */
export class InboxComponent {
    messages: Message[] = [];

    /**
     * Constructor
     * @param messageService 
     */
    constructor(private messageService:MessageService, private alertService:AlertService){}

    /**
     * Method ngOnInit
     */
    ngOnInit(): void {
        this.loadMessages();
    }

    /**
     * Method loadMessages : load messages stored in the backend's database to show them on the web page
     */
    loadMessages(): void {
        console.log("Method loadMessages called");
        this.messageService.getMessages().subscribe(
            (data:any[]) => {
                this.messages = data;
            },
            (error: any) => {
                console.log(error);
              }
        )
    }

    /**
     * Method deleteMessageById : Delete a message in the backend's database in fonction of the given id.
     * @param id : Id of the message to be deleted
     */
    deleteMessageById(id:number): void {
        console.log("Method deleteMessageById called :"+id);
        this.messageService.deleteMessageById(id).subscribe(
            () => {
                console.log("Message deleted");
                this.openAlert("Message supprimé");
                this.loadMessages();
            }
        )
    }

    /**
     * Method openAlert
     * @param msg : message to display
     */
    openAlert(msg:string){
        this.alertService.displayAlert(msg);
    }
}