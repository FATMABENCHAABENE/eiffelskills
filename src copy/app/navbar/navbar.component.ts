import { Component } from "@angular/core"
import { Link } from "models/links.model"

@Component({
  selector: "navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.scss"],
})
export class NavbarComponent {
  links: Link[] = []

  constructor() {
    this.links.push({ name: "CV 1", href: "etudiants" })
    this.links.push({ name: "CV 2", href: "filieres" })
    this.links.push({ name: "Formulaire", href: "filieres" })
  }
}
