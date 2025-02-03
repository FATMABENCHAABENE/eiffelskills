import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Eval, Modules, Qcm, Question, Users, Contact, Comp, Resource } from 'models/model.model';


@Injectable({
  providedIn: 'root'
})

  export class Service {

  private loginIn: number = 0;
  private id: number = 0;
  private major: string = '';
  private module: number = 0; 
  private idMcQ: number = 0;
  private idquestion: number = 0;
  private role: string = '';   

  constructor(private http: HttpClient) { }

  setLoginIn(value : number): void {
    this.loginIn = value;
  }

  getLoginIn(): number {
    return this.loginIn; 
  }

  setMajor(value : string): void {
    this.major = value; 
  }

  getMajor(): string {
    return this.major; 
  }

  setRole(role: string) {
    this.role = role;
  }

  getRole(): string {
    return this.role;
  }

  setId(value : number): void {
    this.id = value;
  }

  getId(): number {
    return this.id; 
  }

  setModule(value : number): void {
    this.module = value; 
  }

  getModule(): number {
    return this.module; 
  }

  setMcq(value : number): void {
    this.idMcQ = value; 
  }

  getMcq(): number {
    return this.idMcQ; 
  }

  setIdquestion(value : number): void {
    this.idquestion = value; 
  }

  getIdquestion(): number {
    return this.idquestion; 
  }

  login(user: Users) {
    return this.http.post<any>('http://localhost:8080/user/login', user);
  }

  getAllInfosMat(major: string) {
    return this.http.get<any[]>(`http://localhost:8080/module/major/${major}`);
  }
  getUserbyMat(major: string) {
    return this.http.get<any[]>(`http://localhost:8080/user/student/${major}`);
  }

  getAllInfosComp(module: number) {
    return this.http.get<any[]>(`http://localhost:8080/skill/module/${module}`); 
  }

  getAllEvals(id: number) {
    return this.http.get<any[]>(`http://localhost:8080/autoeval/student/${id}`);
  }

  getLibelle(idSkill: number) {
    return this.http.get<any[]>(`http://localhost:8080/skill/${idSkill}`);
  }

  updateval(evaluation: Eval) {
    return this.http.post<any>('http://localhost:8080/autoeval/skill', evaluation);
  } 

  getmodulesbyID(id: number) {
    return this.http.get<any[]>(`http://localhost:8080/module/teacher/${id}`);
  }

  sendidmodule(qcm: Qcm) {
    return this.http.post<any[]>(`http://localhost:8080/MCQ`, qcm);
  }

  sendQuestion(newQuestion: Question) {
    return this.http.post<any[]>(`http://localhost:8080/question`, newQuestion);
  }

  envoyerRep(p0: number, reponses: string[]) {
    return this.http.post<any[]>(`http://localhost:8080/awnser/question/${p0}`, reponses);
  }

  envoyerBRep(id: number) {
    return this.http.post<any[]>(`http://localhost:8080/awnser/updateGood`, id);
  }

  getIdQCM(idModule: number) {
    return this.http.get<any[]>(`http://localhost:8080/MCQ/module/${idModule}`);
  }

  getQCM(id: number) {
    return this.http.get<any[]>(`http://localhost:8080/question/MCQ/${id}`);
  }

  getReponse(idQuestion: number) {
      return this.http.get<any[]>(`http://localhost:8080/awnser/question/${idQuestion}`);
  }

  addUser(newUser: Users) {
    return this.http.post<any>('http://localhost:8080/user/add',newUser)
  }

  getAllUser() {
    return this.http.get<any>('http://localhost:8080/user');
  }

  deleteUserById(idUser: number | undefined) {
    return this.http.delete<any>(`http://localhost:8080/user/${idUser}`);
  }

  addModule(newModule: Modules) {
    return this.http.post<any>('http://localhost:8080/module',newModule)
  }

  getAllModule() {
    return this.http.get<any>('http://localhost:8080/module');
  }

  deleteModuleById(idModule: number | undefined) {
    return this.http.delete<any>(`http://localhost:8080/module/${idModule}`);
  }

  addSkill(newSkill: Comp) {
    console.log(newSkill);
    return this.http.post<any>('http://localhost:8080/skill', newSkill);
  }
  deleteSkill(idSkill: number) {
    return this.http.delete<any>(`http://localhost:8080/skill/${idSkill}`);
  }

  envoyerProp(selectedAnswers: number[], idStudent : number) {
    // Logique pour envoyer les réponses sélectionnées
    return this.http.post<any[]>(`http://localhost:8080/awnser/globalcheck/${idStudent}`, selectedAnswers);
  }

  getCompetencesByModule(idmodule: number): Observable<any[]> {
  return this.http.get<any[]>(`http://localhost:8080/skill/module/${idmodule}`);
  }

  sendContact(newContact: Contact) {
    return this.http.post<any[]>(`http://localhost:8080/contactmessage`, newContact);
  }

  getallContact() {
    return this.http.get<any[]>(`http://localhost:8080/contactmessage`);
  }

  deletemessageById(idcontact: number | undefined) {
    return this.http.delete<any>(`http://localhost:8080/contactmessage/${idcontact}`);
  }
  addR(newRessource: Resource) {
    console.log(newRessource);
    return this.http.post<any>('http://localhost:8080/resource', newRessource);
  }
  deleteR(idR: number | undefined) {
    return this.http.delete<any>(`http://localhost:8080/resource/${idR}`);
  }
  getRByModule(idModule: number): Observable<Resource[]> {
    return this.http.get<any>(`http://localhost:8080/resource/module/${idModule}`);
  }
  
  getNote(id: number, item: number) {
    return this.http.get<any>(`http://localhost:8080/skill/score/${id}/${item}`);
  }

  getDescription(item: number) {
    return this.http.get<any[]>(`http://localhost:8080/module/${item}`);
  }
  postid(idStudent: number | undefined, idSkill: number[]) {
    return this.http.post<Eval[]>(`http://localhost:8080/autoeval/student/${idStudent}`,idSkill);
  }
}
