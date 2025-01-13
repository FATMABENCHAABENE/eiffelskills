import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { CvService } from '../services/update.service';
import { Infos } from '../models/home.model';
import { Diplome } from '../models/home.model';
import { ExPro } from '../models/home.model';
import { Skills } from '../models/home.model';
import { Certif } from '../models/home.model';
import { Hobbie } from '../models/home.model';
import { Contact } from '../models/home.model';
import {PersonalInfo, Diploma, Expro } from '../models/infos.model';

@Component({
  selector: "update",
  templateUrl: "../update/update.component.html",
  styleUrls: ["../update/update.component.scss"],
})

export class UpdateComponent implements OnInit {
  formSubmitted: boolean = false;
  formSubmittedDI: boolean = false;
  formSubmittedEX: boolean = false;
  formSubmittedSK: boolean = false;
  formSubmittedCE: boolean = false;
  formSubmittedHO: boolean = false;
  formSubmittedCO: boolean = false;

  nom: string = '';
  prenom: string = '';
  id: number = 0;
  obtentionDate : Date = new Date();
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

  infos: Infos[] = [];
  diplomes: Diplome[] = [];
  expro: ExPro[] = [];
  skills: Skills[] = [];
  certif: Certif[] = [];
  hobbie: Hobbie[] = [];
  contact: Contact[] = [];

  constructor(private cvService: CvService) {}

  ngOnInit(): void {
     this.loadInfos();
     this.loadDiplomes();
     this.loadExPro();
     this.loadSkills();
     this.loadCertif();
     this.loadHobbie();
     this.loadContact();
  }

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

  loadDiplomes(): void {
    console.log("Méthode loadDiplomes() appelée.");
    this.cvService.getAllDiplomes().subscribe(
      (data: Diplome[]) => {
        this.diplomes = data;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  loadExPro(): void {
    console.log("Méthode loadDiplomes() appelée.");
    this.cvService.getAllExPro().subscribe(
      (data: ExPro[]) => {
        this.expro = data;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  loadSkills(): void {
    console.log("Méthode loadDiplomes() appelée.");
    this.cvService.getAllSkills().subscribe(
      (data: Skills[]) => {
        this.skills = data;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  loadCertif(): void {
    console.log("Méthode loadDiplomes() appelée.");
    this.cvService.getAllCertif().subscribe(
      (data: Certif[]) => {
        this.certif = data;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  loadHobbie(): void {
    console.log("Méthode loadHobbie() appelée.");
    this.cvService.getAllHobbie().subscribe(
      (data: Hobbie[]) => {
        this.hobbie = data;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  loadContact(): void {
    console.log("Méthode loadHobbie() appelée.");
    this.cvService.getAllContact().subscribe(
      (data: Contact[]) => {
        this.contact = data;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  refresh(): void{
    this.formSubmitted = false;
    this.formSubmittedDI = false;
    this.formSubmittedEX = false;
    this.formSubmittedSK = false;
    this.formSubmittedCE = false;
    this.formSubmittedHO = false;
    this.formSubmittedCO = false;
  }



  updateFormPersonalinfo(): void {
    this.refresh();
    console.log("name = " + this.name + "surname = " + this.surname + "birth = " + this.birth + "id = " + this.id);
    if (!this.surname || !this.name || !this.birth || !this.id) {
        console.log('[UPDATE] Veuillez entrer des données valides');
        return;
    }

    const personalinfo: PersonalInfo = {
      surname: this.surname,
      name: this.name,
      birth: this.birth
    };

    this.cvService.updatePersonalInfo(personalinfo, this.id).subscribe(
        (data: any) => {
            console.log('Infos enregistrées avec succès !', data);
            this.formSubmitted = true;
        },
        (error: any) => {
            console.log('Erreur lors de l\'enregistrement des infos : ', error);
        }
    );
  }


  updateFormDiploma(): void {
    this.refresh();
    console.log("name = " + this.name + "school = " + this.school + "date obtention = " + this.obtentionDate + "id = " + this.id);
    if (!this.name || !this.school  || !this.obtentionDate || !this.id) {
        console.log('[UPDATE] Veuillez entrer des données valides');
        return;
    }

    const diplomes: Diploma = {
      obtentionDate: this.obtentionDate,
      name: this.name,
      school: this.school
    };

    this.cvService.updateDiplomaById(diplomes, this.id).subscribe(
        (data: any) => {
            console.log('Infos enregistrées avec succès !', data);
            this.formSubmittedDI = true;
        },
        (error: any) => {
            console.log('Erreur lors de l\'enregistrement des infos : ', error);
        }
    );
  }

  updateFormExPro(): void {
    this.refresh();
    if (!this.nameC || !this.beginD  || !this.endD || !this.job || !this.id) {
        console.log('[UPDATE] Veuillez entrer des données valides');
        return;
    }

    const expro: Expro = {
      nameC: this.nameC,
      beginD: this.beginD,
      endD: this.endD,
      job: this.job
    };

    this.cvService.updateExProById(expro, this.id).subscribe(
        (data: any) => {
            console.log('Infos enregistrées avec succès !', data);
            this.formSubmittedEX = true;
        },
        (error: any) => {
            console.log('Erreur lors de l\'enregistrement des infos : ', error);
        }
    );
  }

  updateFormSkills(): void {
    this.refresh();
    if (!this.domains || !this.details  || !this.id) {
        console.log('[UPDATE] Veuillez entrer des données valides');
        return;
    }

    const skills: Skills = {
      domains: this.domains,
      details: this.details
    };

    this.cvService.updateSkillsById(skills, this.id).subscribe(
        (data: any) => {
            console.log('Infos enregistrées avec succès !', data);
            this.formSubmittedSK = true;
        },
        (error: any) => {
            console.log('Erreur lors de l\'enregistrement des infos : ', error);
        }
    );
  }

  updateFormCertif(): void {
    this.refresh();
    if (!this.name || !this.domain  || !this.id) {
        console.log('[UPDATE] Veuillez entrer des données valides');
        return;
    }

    const certif: Certif = {
      name: this.name,
      domain: this.domain
    };

    this.cvService.updateCertifById(certif, this.id).subscribe(
        (data: any) => {
            console.log('Infos enregistrées avec succès !', data);
            this.formSubmittedCE = true;
        },
        (error: any) => {
            console.log('Erreur lors de l\'enregistrement des infos : ', error);
        }
    );
  }

  updateFormHobbie(): void {
    this.refresh();
    if (!this.description || !this.id) {
        console.log('[UPDATE] Veuillez entrer des données valides');
        return;
    }

    const hobbie: Hobbie = {
      description: this.description
    };

    this.cvService.updateHobbie(hobbie, this.id).subscribe(
        (data: any) => {
            console.log('Infos enregistrées avec succès !', data);
            this.formSubmittedHO = true;
        },
        (error: any) => {
            console.log('Erreur lors de l\'enregistrement des infos : ', error);
        }
    );
  }

  updateFormContact(): void {
    this.refresh();
    if (!this.info || !this.type || !this.id) {
        console.log('[UPDATE] Veuillez entrer des données valides');
        return;
    }

    const contact: Contact = {
      info: this.info,
      type: this.type
    };

    this.cvService.updateContactById(contact, this.id).subscribe(
        (data: any) => {
            console.log('Infos enregistrées avec succès !', data);
            this.formSubmittedCO = true;
        },
        (error: any) => {
            console.log('Erreur lors de l\'enregistrement des infos : ', error);
        }
    );
  }

}


