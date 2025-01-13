import { Observable } from 'rxjs';
import { Message } from 'models/home.model'; // Import du modèle Message
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class MessageService {
    private baseUrl = "http://localhost:8080/Message"; // URL de base pour les messages

    constructor(private http: HttpClient) {}

    // Méthode pour envoyer un message
    sendMessage(message: Message): Observable<any[]> {
        console.log("Message Posting");
        return this.http.post<any[]>(this.baseUrl,message);
    }

    // Méthode pour récupérer tous les messages
    getMessages(): Observable<any[]> {
        console.log("Getting Messages");
        return this.http.get<any[]>(this.baseUrl);
    }

    // Méthode pour supprimer un message par son identifiant
    deleteMessageById(id:number): Observable<any[]> {
        console.log("Deleting message : "+id);
        return this.http.delete<any[]>(this.baseUrl+"/"+(id));
    }
}
