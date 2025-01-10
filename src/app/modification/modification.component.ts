// Importation des modules
import { Component, OnInit } from "@angular/core";
import { CvService } from '../services/modification.service';
import { Infos } from '../models/modification.model';
import { Diplome } from '../models/modification.model';
import { ExPro } from '../models/modification.model';
import { Skills } from '../models/modification.model';
import { Certif } from '../models/modification.model';
import { Hobbie } from '../models/modification.model';
import { Contact } from '../models/modification.model';

@Component({
  selector: "modification",
  templateUrl: "./modification.component.html",
  styleUrls: ["./modification.component.scss"],
})
export class modificationComponent implements OnInit {
  // Déclaration des variables
  nom: string = "";
  prenom: string = "";
  infos: Infos[] = [];
  diplomes: Diplome[] = [];
  expro: ExPro[] = [];
  skills: Skills[] = [];
  certif: Certif[] = [];
  hobbie: Hobbie[] = [];
  contact: Contact[] = [];
  highlightedItemId: number = 0 ;

  // Constructeur
  constructor(private cvService: CvService) {} 

  // Initialisation
  ngOnInit(): void {
     this.loadInfos();
     this.loadDiplomes();
     this.loadExPro();
     this.loadSkills();
     this.loadCertif();
     this.loadHobbie();
     this.loadContact();
  }

  // Méthodes de chargement des données
  loadInfos(): void {
    this.cvService.getAllInfos().subscribe(
      (data: Infos[]) => {
        this.infos = data;
      },
      (error: any) => {
        console.log("Erreur lors du chargement des informations personnelles :", error);
      }
    );
  }

  loadDiplomes(): void {
    this.cvService.getAllDiplomes().subscribe(
      (data: Diplome[]) => {
        this.diplomes = data;
      },
      (error: any) => {
        console.log("Erreur lors du chargement des diplômes :", error);
      }
    );
  }

  loadExPro(): void {
    this.cvService.getAllExPro().subscribe(
      (data: ExPro[]) => {
        this.expro = data;
      },
      (error: any) => {
        console.log("Erreur lors du chargement des expériences professionnelles :", error);
      }
    );
  }

  loadSkills(): void {
    this.cvService.getAllSkills().subscribe(
      (data: Skills[]) => {
        this.skills = data;
      },
      (error: any) => {
        console.log("Erreur lors du chargement des compétences :", error);
      }
    );
  }

  loadCertif(): void {
    this.cvService.getAllCertif().subscribe(
      (data: Certif[]) => {
        this.certif = data;
      },
      (error: any) => {
        console.log("Erreur lors du chargement des certifications :", error);
      }
    );
  }

  loadHobbie(): void {
    this.cvService.getAllHobbie().subscribe(
      (data: Hobbie[]) => {
        this.hobbie = data;
      },
      (error: any) => {
        console.log("Erreur lors du chargement des centres d'intérêt :", error);
      }
    );
  }

  loadContact(): void {
    this.cvService.getAllContact().subscribe(
      (data: Contact[]) => {
        this.contact = data;
      },
      (error: any) => {
        console.log("Erreur lors du chargement des contacts :", error);
      }
    );
  }

  deleteInfo(id: number): void {
    if (typeof id === 'number') {
      console.log("Méthode deleteInfo() appelée avec l'ID :", id);
      // Appel à la méthode de service pour supprimer l'info avec l'ID spécifié
      this.cvService.deleteInfo(id).subscribe(
        () => {
          console.log(`Info avec l'ID ${id} supprimée avec succès.`);
          // Mettre à jour la liste des infos après la suppression
          this.loadInfos();
        }
      );
    } else {
      console.error("ID non valide pour la suppression de l'info.");
    }
  }
  
  deleteDiplome(id: number): void {
    if (typeof id === 'number') {
      console.log("Méthode deleteDiplome() appelée avec l'ID :", id);
      // Appel à la méthode de service pour supprimer le diplôme avec l'ID spécifié
      this.cvService.deleteDiplome(id).subscribe(
        () => {
          console.log(`Diplôme avec l'ID ${id} supprimé avec succès.`);
          // Mettre à jour la liste des diplômes après la suppression
          this.loadDiplomes();
        }
      );
    } else {
      console.error("ID non valide pour la suppression du diplôme.");
    }
  }
  
  // Implémentez de manière similaire pour les autres méthodes de suppression
  
  deleteExPro(id: number): void {
    if (typeof id === 'number') {
      console.log("Méthode deleteExPro() appelée avec l'ID :", id);
      // Appel à la méthode de service pour supprimer l'expérience professionnelle avec l'ID spécifié
      this.cvService.deleteExPro(id).subscribe(
        () => {
          console.log(`Expérience professionnelle avec l'ID ${id} supprimée avec succès.`);
          // Mettre à jour la liste des expériences professionnelles après la suppression
          this.loadExPro();
        }
      );
    } else {
      console.error("ID non valide pour la suppression de l'expérience professionnelle.");
    }
  }
  
  // Implémentez de manière similaire pour les autres méthodes de suppression
  
  deleteSkill(id: number): void {
    if (typeof id === 'number') {
      console.log("Méthode deleteSkill() appelée avec l'ID :", id);
      // Appel à la méthode de service pour supprimer la compétence avec l'ID spécifié
      this.cvService.deleteSkill(id).subscribe(
        () => {
          console.log(`Compétence avec l'ID ${id} supprimée avec succès.`);
          // Mettre à jour la liste des compétences après la suppression
          this.loadSkills();
        }
      );
    } else {
      console.error("ID non valide pour la suppression de la compétence.");
  }
  }
  
  // Implémentez de manière similaire pour les autres méthodes de suppression
  

  deleteCertif(id: number): void {
    if (typeof id === 'number') {
      console.log("Méthode deleteCertif() appelée avec l'ID :", id);
      // Appel à la méthode de service pour supprimer la certification avec l'ID spécifié
      this.cvService.deleteCertif(id).subscribe(
        () => {
          console.log(`Compétence avec l'ID ${id} supprimée avec succès.`);
          // Mettre à jour la liste des compétences après la suppression
          this.loadCertif();
        }
      )
    } else {
      console.error("ID non valide pour la suppression de la certification.");
    }
  }

  deleteHobbie(id: number): void {
    if (typeof id === 'number') {
      console.log("Méthode deleteHobbie() appelée avec l'ID :", id);
      // Appel à la méthode de service pour supprimer le centre d'intérêt avec l'ID spécifié
      this.cvService.deleteHobbie(id).subscribe(
        () => {
          console.log(`Compétence avec l'ID ${id} supprimée avec succès.`);
          // Mettre à jour la liste des compétences après la suppression
          this.loadHobbie();
        }
      )
    } else {
      console.error("ID non valide pour la suppression du centre d'intérêt.");
    }
  }

  deleteContact(id: number): void {
    if (typeof id === 'number') {
      console.log("Méthode deleteContact() appelée avec l'ID :", id);
      // Appel à la méthode de service pour supprimer le contact avec l'ID spécifié
      this.cvService.deleteContact(id).subscribe(
        () => {
          console.log(`Compétence avec l'ID ${id} supprimée avec succès.`);
          // Mettre à jour la liste des compétences après la suppression
          this.loadContact();
        }
      )
    } else {
      console.error("ID non valide pour la suppression du contact.");
    }
  }


  //all

  
  deleteallI(): void {
      this.cvService.deleteAllInfo().subscribe(
        () => {
          console.log(`Info avec l'ID supprimée avec succès.`);
          // Mettre à jour la liste des infos après la suppression
          this.loadInfos();
        },
        (error: any) => {
          console.error(`Erreur lors de la suppression de l'info avec l'ID :`, error);
        }
      );
  }
  deleteallD(): void {
    this.cvService.deleteAllDiplome().subscribe(
      () => {
        console.log(`Info avec l'ID supprimée avec succès.`);
        // Mettre à jour la liste des infos après la suppression
        this.loadDiplomes();
      },
      (error: any) => {
        console.error(`Erreur lors de la suppression de l'info avec l'ID :`, error);
      }
    );
}
deleteallE(): void {
  this.cvService.deleteAllExpro().subscribe(
    () => {
      console.log(`Info avec l'ID supprimée avec succès.`);
      // Mettre à jour la liste des infos après la suppression
      this.loadExPro();
    },
    (error: any) => {
      console.error(`Erreur lors de la suppression de l'info avec l'ID :`, error);
    }
  );
}

deleteallH(): void {
  this.cvService.deleteAllHobbie().subscribe(
    () => {
      console.log(`Info avec l'ID supprimée avec succès.`);
      // Mettre à jour la liste des infos après la suppression
      this.loadHobbie();
    },
    (error: any) => {
      console.error(`Erreur lors de la suppression de l'info avec l'ID :`, error);
    }
  );
}

deleteallC(): void {
  this.cvService.deleteAllCertif().subscribe(
    () => {
      console.log(`Info avec l'ID supprimée avec succès.`);
      // Mettre à jour la liste des infos après la suppression
      this.loadCertif();
    },
    (error: any) => {
      console.error(`Erreur lors de la suppression de l'info avec l'ID :`, error);
    }
  );
}
deleteallS(): void {
  this.cvService.deleteAllSkill().subscribe(
    () => {
      console.log(`Info avec l'ID supprimée avec succès.`);
      // Mettre à jour la liste des infos après la suppression
      this.loadSkills();
    },
    (error: any) => {
      console.error(`Erreur lors de la suppression de l'info avec l'ID :`, error);
    }
  );
}
deleteallCT(): void {
  this.cvService.deleteAllContact().subscribe(
    () => {
      console.log(`Info avec l'ID supprimée avec succès.`);
      // Mettre à jour la liste des infos après la suppression
      this.loadContact();
    },
    (error: any) => {
      console.error(`Erreur lors de la suppression de l'info avec l'ID :`, error);
    }
  );
}
}