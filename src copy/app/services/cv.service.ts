import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Diploma, Expro, Infos, PersonalInfo, Certif, Skills, Hobbie, Contact } from '../models/infos.model'; // Import des modèles pour les informations personnelles

@Injectable({
  providedIn: 'root'
})
export class CvService {

  private baseUrl = 'http://localhost:8080/infos'; // URL de base pour les informations personnelles
  private baseUrlD = 'http://localhost:8080/Diploma'; // URL de base pour les diplômes
  
  constructor(private http: HttpClient) { }

  // Récupérer toutes les informations personnelles
  getAllInfos(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl); 
  }

  // Enregistrer des informations personnelles
  enregistrerInfos(info: Infos): Observable<any> {
    console.log('Appel de la méthode enregistrerInfos() avec les informations:', info);
    return this.http.post<any>('http://localhost:8080/infos/enregistrer', info);
  }

  // Ajouter un diplôme
  addDiploma(diplomes : Diploma): Observable<any>{
    console.log('Appel de la méthode addDiploma() avec les informations:', diplomes);
    return this.http.post<any>('http://localhost:8080/Diploma/enregistrer', diplomes);
  }  

  // Ajouter une expérience professionnelle
  addPro(expro : Expro): Observable<any>{
    console.log('Appel de la méthode addPro() avec les informations:', expro);
    return this.http.post<any>('http://localhost:8080/ExPro', expro);
  } 
  

  // Ajouter des compétences
  addSkills(skills : Skills): Observable<any>{
    console.log('Appel de la méthode addSkills() avec les informations:', skills);
    return this.http.post<any>('http://localhost:8080/Skills', skills);
  }  

  // Ajouter une certification
  addCertif(certif : Certif): Observable<any>{
    console.log('Appel de la méthode addCertif() avec les informations:', certif);
    return this.http.post<any>('http://localhost:8080/Certif', certif);
  }  

  // Ajouter un centre d'intérêt
  addHobbie(hobbie : Hobbie): Observable<any>{
    console.log('Appel de la méthode addCertif() avec les informations:', hobbie);
    return this.http.post<any>('http://localhost:8080/Hobbie', hobbie);
  } 

  // Ajouter un contact
  addContact(contact : Contact): Observable<any>{
    console.log('Appel de la méthode addContact() avec les informations:', contact);
    return this.http.post<any>('http://localhost:8080/Contact', contact);
  }

  // Ajouter des informations personnelles
  addPersonalInfo(personalinfo : PersonalInfo): Observable<any>{
    console.log('Appel de la méthode addpersonalinfo() avec les informations:', personalinfo);
    return this.http.post<any>('http://localhost:8080/PersonalInfo', personalinfo);
  }
  
}
