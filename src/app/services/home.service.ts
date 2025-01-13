import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Infos } from '../models/home.model';

@Injectable({
  providedIn: 'root'
})
export class CvService {

  private baseUrl = 'http://localhost:8080/PersonalInfo';
  private baseUrlD = 'http://localhost:8080/Diploma';
  private baseUrlE = 'http://localhost:8080/ExPro'; 
  private baseUrlS = 'http://localhost:8080/Skills';
  private baseUrlC = 'http://localhost:8080/Certif';
  private baseUrlH = 'http://localhost:8080/Hobbie';
  private baseUrlCT = 'http://localhost:8080/Contact';     
  

  constructor(private http: HttpClient) { }

  getAllInfos(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl); 
  }

  getAllDiplomes(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrlD); 
  }

  getAllExPro(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrlE); 
  }

  getAllSkills(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrlS); 
  }

  getAllCertif(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrlC); 
  }

  getAllHobbie(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrlH); 
  }

  getAllContact(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrlCT); 
  }

}



