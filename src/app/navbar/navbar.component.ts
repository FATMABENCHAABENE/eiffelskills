import { Component } from "@angular/core"
import { Router } from "@angular/router";


@Component({
  selector: "navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.scss"],
})
export class NavbarComponent {
  showNavbar: boolean = true; // Variable pour contrôler l'affichage de la navbar

  constructor(private router: Router) {
    // Abonne-toi aux changements de route pour détecter l'URL active
    this.router.events.subscribe(() => {
      // Si l'URL est '/', cache la navbar
      this.showNavbar = this.router.url !== "/";
    });
  }
}
