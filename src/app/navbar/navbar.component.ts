import { Component } from "@angular/core"
import { Router } from "@angular/router";
import { Service } from "services/service.service";


@Component({
  selector: "navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.scss"],
})
export class NavbarComponent {
  showNavbar: boolean = true; // Variable pour contrôler l'affichage de la navbar

  constructor(private router: Router, private service: Service) {
    // Abonne-toi aux changements de route pour détecter l'URL active
    this.router.events.subscribe(() => {
      // Si l'URL est '/', cache la navbar
      this.showNavbar = this.router.url !== "/";
    });
  }

  redirectMain() {
    switch (this.service.getRole()) {
      case "student":
        this.router.navigate(['/modulestudent']);
        break;
      case "teacher":
        this.router.navigate(['/moduleteacher']);
        break;
      case "admin":
        this.router.navigate(['/moduleadmin']);
        break;
      default:
        this.router.navigate(['/'])
        break;
    }
  }
}
