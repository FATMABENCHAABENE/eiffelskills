// app-routing.module.ts
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AccueilComponent } from "./accueil/accueil.component";
import { LoginComponent } from "login/login.component";
import { ModulestudentComponent } from "modulestudent/modulestudent.component";
import { AutoevalComponent } from "autoeval/autoeval.component";
import { ModuleteacherComponent } from "moduleteacher/moduleteacher.component";
import { CreerquizzComponent } from "creerquizz/creerquizz.component";
import { ShowevalComponent } from "showeval/showeval.component";
import { ShowquizzComponent } from "showquizz/showquizz.component";
import { RepondrequizzComponent } from "repondrequizz/repondrequizz.component";
import { ModuleadminComponent } from "moduleadmin/moduleadmin.component";
import { ContactComponent } from "contact/contact.component";
import {SkillComponent} from "skill/skill.component";

const routes: Routes = [
  { path: "", component: AccueilComponent },
  { path: "login", component: LoginComponent },
  { path: "modulestudent", component: ModulestudentComponent },
  { path: "autoeval", component: AutoevalComponent },
  { path: "moduleteacher", component: ModuleteacherComponent },
  { path: "creerquizz", component: CreerquizzComponent }, 
  { path: "showeval", component: ShowevalComponent },
  { path: "showquizz", component: ShowquizzComponent }, 
  { path: "repondrequizz", component: RepondrequizzComponent },
  { path: "moduleadmin", component: ModuleadminComponent},
  { path: "contact", component: ContactComponent},
  { path: "skill", component: SkillComponent} 
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
