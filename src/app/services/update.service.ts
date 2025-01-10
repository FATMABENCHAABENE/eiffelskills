import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Diploma, Expro, Infos, PersonalInfo } from '../models/infos.model'; // Import des modèles Infos et PersonalInfo
import { Certif, Skills, Hobbie, Contact, ExPro } from 'models/home.model'; // Import des modèles Certif, Skills, Hobbie, Contact, ExPro

@Injectable({
  providedIn: 'root'
})
export class CvService {

  // Déclaration des URLs de base pour les différentes entités
  private baseUrl = 'http://localhost:8080/PersonalInfo';
  private baseUrlD = 'http://localhost:8080/Diploma';
  private baseUrlE = 'http://localhost:8080/ExPro'; 
  private baseUrlS = 'http://localhost:8080/Skills';
  private baseUrlC = 'http://localhost:8080/Certif';
  private baseUrlH = 'http://localhost:8080/Hobbie';
  private baseUrlCT = 'http://localhost:8080/Contact';     

  constructor(private http: HttpClient) { }

  // Méthode pour récupérer toutes les informations personnelles
  getAllInfos(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl); 
  }

  // Méthode pour récupérer tous les diplômes
  getAllDiplomes(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrlD); 
  }

  // Méthode pour récupérer toutes les expériences professionnelles
  getAllExPro(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrlE); 
  }

  // Méthode pour récupérer toutes les compétences
  getAllSkills(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrlS); 
  }

  // Méthode pour récupérer toutes les certifications
  getAllCertif(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrlC); 
  }

  // Méthode pour récupérer tous les centres d'intérêt
  getAllHobbie(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrlH); 
  }

  // Méthode pour récupérer tous les contacts
  getAllContact(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrlCT); 
  }

  // Méthode pour mettre à jour les informations personnelles par leur ID
  updatePersonalInfo(personalinfo : PersonalInfo, id: number): Observable<any>{
    console.log('Appel de la méthode updatepersonalinfo() avec les informations:', personalinfo);
    console.log('id:', id);
    return this.http.post<any>('http://localhost:8080/PersonalInfo/2', personalinfo);
  }

  // Méthode pour mettre à jour un diplôme par son ID
  updateDiplomaById(diplome: Diploma, id: number): Observable<any> {
    console.log('Appel de la méthode updateDiploma() avec les informations:', diplome);
    console.log(id);
    const numericId: number = Number(id); 
    return this.http.post<any>(`http://localhost:8080/Diploma/${numericId}`, diplome);
  }
 
  // Méthode pour mettre à jour une expérience professionnelle par son ID
  updateExProById(expro: ExPro, id: number): Observable<any> {
    console.log('Appel de la méthode updateExpro() avec les informations:', expro);
    console.log(id);
    const numericId: number = Number(id); 
    return this.http.post<any>(`http://localhost:8080/ExPro/${numericId}`, expro);
  }

  // Méthode pour mettre à jour des compétences par leur ID
  updateSkillsById(skills: Skills, id: number): Observable<any> {
    console.log('Appel de la méthode updateSkills() avec les informations:', skills);
    console.log(id);
    const numericId: number = Number(id); 
    return this.http.post<any>(`http://localhost:8080/Skills/${numericId}`, skills);
  }


  // Méthode pour mettre à jour une certification par son ID
  updateCertifById(certif: Certif, id: number): Observable<any> {
    console.log('Appel de la méthode updateDiploma() avec les informations:', certif);
    console.log(id);
    const numericId: number = Number(id); 
    return this.http.post<any>(`http://localhost:8080/Certif/${numericId}`, certif);
  }

  // Méthode pour mettre à jour un centre d'intérêt par son ID
  updateHobbie(hobbie: Hobbie, id: number): Observable<any> {
    console.log('Appel de la méthode updateDiploma() avec les informations:', hobbie);
    console.log(id);
    const numericId: number = Number(id); 
    return this.http.post<any>(`http://localhost:8080/Hobbie/${numericId}`, hobbie);
  }

  updateContactById(contact: Contact, id: number): Observable<any> {
    console.log('Appel de la méthode updateContact() avec les informations:', contact);
    console.log(id);
    const numericId: number = Number(id); 
    return this.http.post<any>(`http://localhost:8080/Contact/${numericId}`, contact);
  }
  
}
