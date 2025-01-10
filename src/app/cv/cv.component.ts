import { Component, OnInit } from '@angular/core';
import { CvService } from '../services/cv.service';
import { AlertService } from '../services/alert.service'; 
import { Infos, Contact, PersonalInfo } from '../models/infos.model';
import { Diploma, Expro, Skills, Certif, Hobbie } from '../models/infos.model';

@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.scss']
})

export class CvComponent implements OnInit {
  // Déclarations des variables
  nom: string = '';
  prenom: string = '';
  obtentionDate: Date = new Date();
  name: string = '';
  school: string = '';
  nameC: string = '';
  beginD: Date = new Date();
  endD: Date = new Date();
  job: string = '';
  domains: string = '';
  details: string = '';
  domain: string = '';
  description: string = '';
  type: string = '';
  info: string = '';
  surname: string = '';
  birth: Date = new Date();

  infos: any[] | undefined;
  diplomes: any[] | undefined;
  expro: any[] | undefined;
  skills: any[] | undefined;
  certif: any[] | undefined;
  hobbie: any[] | undefined;
  contact: any[] | undefined;
  personalinfo: any[] | undefined;

  constructor(private cvService: CvService, private alertService: AlertService) { }

  ngOnInit(): void {
    this.loadInfos();
  }

  // Fonction pour afficher une alerte
  openAlert(msg: string): void {
    this.alertService.displayAlert(msg);
  }

  // Fonction pour charger les informations
  loadInfos(): void {
    console.log("Méthode loadInfos() appelée.");
    this.cvService.getAllInfos().subscribe(
      (data: any[]) => {
        this.infos = data;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  // Soumission du formulaire pour les informations personnelles
  submitFormPersonalinfo(): void {
    if (!this.surname || !this.name || !this.birth) {
      this.openAlert('Veuillez entrer des données valides.');
      return;
    }
    console.log('ok nous sommes passés');

    const personalinfo: PersonalInfo = {
      surname: this.surname,
      name: this.name,
      birth: this.birth
    };

    this.cvService.addPersonalInfo(personalinfo).subscribe(
      (data: any) => {
        this.openAlert('Infos enregistrées avec succès !');
      },
      (error: any) => {
        this.openAlert('Erreur lors de l\'enregistrement des infos : ' + error); // Affichage de l'erreur
      }
    );
  }

  // Soumission du formulaire pour l'expérience professionnelle
  submitFormPro(): void {
    if (!this.nameC || !this.beginD || !this.endD || !this.job) {
      this.openAlert('Veuillez entrer des données valides.');
      return;
    }
    console.log('ok nous sommes passés');
    const expro: Expro = {
      nameC: this.nameC,
      beginD: this.beginD,
      endD: this.endD,
      job: this.job
    };

    this.cvService.addPro(expro).subscribe(
      (data: any) => {
        this.openAlert('Infos enregistrées avec succès !');
      },
      (error: any) => {
        this.openAlert('Erreur lors de l\'enregistrement des infos : ' + error); // Affichage de l'erreur
      }
    );
  }

  // Soumission du formulaire pour les compétences
  submitFormSkills(): void {
    if (!this.domains || !this.details) {
      this.openAlert('Veuillez entrer des données valides.');
      return;
    }
    console.log('ok nous sommes passés');
    const skills: Skills = {
      domains: this.domains,
      details: this.details
    };

    this.cvService.addSkills(skills).subscribe(
      (data: any) => {
        this.openAlert('Infos enregistrées avec succès !');
      },
      (error: any) => {
        this.openAlert('Erreur lors de l\'enregistrement des infos : ' + error); // Affichage de l'erreur
      }
    );
  }

  // Soumission du formulaire pour les certifications
  submitFormCertif(): void {
    if (!this.name || !this.domain) {
      this.openAlert('Veuillez entrer des données valides.');
      return;
    }
    console.log('ok nous sommes passés');

    const certif: Certif = {
      name: this.name,
      domain: this.domain
    };

    this.cvService.addCertif(certif).subscribe(
      (data: any) => {
        this.openAlert('Infos enregistrées avec succès !');
      },
      (error: any) => {
        this.openAlert('Erreur lors de l\'enregistrement des infos : ' + error); // Affichage de l'erreur
      }
    );
  }

  // Soumission du formulaire pour les loisirs
  submitFormHobbie(): void {
    if (!this.description) {
      this.openAlert('Veuillez entrer des données valides.');
      return;
    }
    console.log('ok nous sommes passés');

    const hobbie: Hobbie = {
      description: this.description
    };

    this.cvService.addHobbie(hobbie).subscribe(
      (data: any) => {
        this.openAlert('Infos enregistrées avec succès !');
      },
      (error: any) => {
        this.openAlert('Erreur lors de l\'enregistrement des infos : ' + error); // Affichage de l'erreur
      }
    );
  }

  // Soumission du formulaire pour les contacts
  submitFormContact(): void {
    if (!this.type || !this.info) {
      this.openAlert('Veuillez entrer des données valides.');
      return;
    }
    console.log('ok nous sommes passés');

    const contact: Contact = {
      type: this.type,
      info: this.info
    };

    this.cvService.addContact(contact).subscribe(
      (data: any) => {
        this.openAlert('Infos enregistrées avec succès !');
      },
      (error: any) => {
        this.openAlert('Erreur lors de l\'enregistrement des infos : ' + error); // Affichage de l'erreur
      }
    );
  }

  // Soumission du formulaire principal
  submitForm(): void {
    // Vérifier si les données sont valides
    if (!this.name || !this.school || !this.obtentionDate) {
      this.openAlert('Veuillez entrer un nom, une école et une date d\'obtention valides.');
      return;
    }
  
    // Créer un objet Diploma avec les données entrées
    const diplomes: Diploma = {
      obtentionDate: this.obtentionDate,
      name: this.name,
      school: this.school
    };
  
    // Appeler la méthode addDiploma du service cvService
    this.cvService.addDiploma(diplomes).subscribe(
      (data: any) => {
        this.openAlert('Infos enregistrées avec succès !');
      },
      (error: any) => {
        this.openAlert('Erreur lors de l\'enregistrement des infos : ' + error); // Affichage de l'erreur
      }
    );
  }
}
