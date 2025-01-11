import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Log } from '../models/home.model';

@Injectable({
  providedIn: 'root'
})

export class LogService {

  private baseUrl = 'http://localhost:8080/User' ;

  constructor(private http: HttpClient) { }

  getAllInfos(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }
}



