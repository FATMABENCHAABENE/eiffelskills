import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../services/service.service';
import { Users } from 'models/model.model';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit {
  loginIn: number = 0; 
  name: string = ''; 
  surname: string = ''; 
  mail: string = ''; 
  password : string = ''; 
  role: string = ' ';
  major: string = '';

  users: Users[] = [];
  majors = ['student_SIC', 'student_BDA', 'student_SE'];
  responseMessage: any;

  constructor(private service: Service, private router: Router) { }

  ngOnInit(): void {
    this.loginIn = this.service.getLoginIn(); 
  }

  tentativelogin(): void {

    if (this.loginIn === 1) {
      this.role = this.major; 
    } else if(this.loginIn == 2 ) {
      this.role = "teacher";
    } else if(this.loginIn == 3) {
      this.role = "admin";
    }

    const user: Users = {
      name: this.name,
      surname: this.surname,
      mail: this.mail,
      password: this.password,
      role: this.role,
      major: ''
    };
    
    //console.log('Utilisateur connecté:', user);

    this.service.login(user).subscribe(
      (data: any) => {
        alert('Connexion réussie !');
        this.responseMessage = data;  
        console.log('Réponse retour du backend:', this.responseMessage);
        if(this.responseMessage.role == "student_SIC") {
          alert('En continuant la navigation, vous consentez à ce que vos résultat de quizz ainsi que votre mail soit visibles par des recruteurs.\n'+
            'Dans le cas contraire, nous vous invitons à envoyer un message dans la section contact pour demander la suppression de votre compte.');
          this.service.setMajor("SIC");
          this.service.setRole('student');
          this.service.setId(this.responseMessage.id);
          this.router.navigate(['/modulestudent']);
        } else if(this.responseMessage.role == "student_BDA"){
          alert('En continuant la navigation, vous consentez à ce que vos résultat de quizz ainsi que votre mail soit visibles par des recruteurs.\n'+
            'Dans le cas contraire, nous vous invitons à envoyer un message dans la section contact pour demander la suppression de votre compte.');
          this.service.setMajor("BDA");
          this.service.setRole('student');
          this.service.setId(this.responseMessage.id);
          this.router.navigate(['/modulestudent']);
        }else if(this.responseMessage.role == "student_SE")
        {
          alert('En continuant la navigation, vous consentez à ce que vos résultat de quizz ainsi que votre mail soit visibles par des recruteurs.\n'+
            'Dans le cas contraire, nous vous invitons à envoyer un message dans la section contact pour demander la suppression de votre compte.');
          this.service.setMajor("SE");
          this.service.setRole('student');
          this.service.setId(this.responseMessage.id);
          this.router.navigate(['/modulestudent']);
        }else if(this.responseMessage.role == "teacher")
        {
          console.log("je suis un professeur");
          alert('En continuant la navigation, vous consentez à ce que les quizzes, compétences et ressources que vous créez soit utilisez par les étudiants');
          this.service.setRole('teacher');
          this.service.setId(this.responseMessage.id);
          this.router.navigate(['/moduleteacher']);
        }else if(this.responseMessage.role == "admin") {
          console.log("je suis admin");
          this.service.setRole('admin');
          this.service.setId(this.responseMessage.id)
          this.router.navigate(['/moduleadmin'])
        }
      }, 
      (error: any) => {
        alert('Connexion échouée. L\'adresse mail ou le mot de passe est incorrect.');
        this.responseMessage = error.message || 'Erreur inconnue'; 
      }
    );
  }
}
