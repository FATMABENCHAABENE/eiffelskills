// app-routing.module.ts
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "home/home.component";
import { MajorsComponent } from "majors/majors.component";
import { MajorsResolver } from "majors/majors.resolver";
import { MajorStudentsResolver } from "majors/major-students/major-students.resolver";
import { MajorStudentsComponent } from "majors/major-students/major-students.component";
import { CvComponent } from "./cv/cv.component"; // Ajoutez l'import pour CvComponent
import { MessageFormComponent } from "messageform/messageform.component";
import { modificationComponent } from "./modification/modification.component";
import { InboxComponent } from "inbox/inbox.component";
import { UpdateComponent } from "./update/update.component";

const routes: Routes = [
  { path: "", component: HomeComponent },
  {
    path: "filieres",
    component: MajorsComponent,
    resolve: {
      majors: MajorsResolver,
    },
  },
  {
    path: "etudiants-filiere/:id",
    component: MajorStudentsComponent,
    resolve: {
      studentsFromMajor: MajorStudentsResolver,
    },
  },
  {
    path: "cv1", // Ajoutez la route pour le formulaire CV 1
    component: CvComponent,
  },
  {
    path: "messageform",
    component: MessageFormComponent,
  },
  {
    path: "modification",
    component: modificationComponent,
  },
  {
    path: "inbox",
    component: InboxComponent,
  },
  {
    path: "update",
    component: UpdateComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
