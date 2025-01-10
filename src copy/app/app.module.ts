// app.module.ts
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule } from "@angular/forms"; // Importez FormsModule

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NavbarComponent } from "./navbar/navbar.component";
import { MatListModule } from "@angular/material/list";
import { HomeComponent } from "./home/home.component";
import { MatIconModule } from "@angular/material/icon";
import { MatButtonModule } from "@angular/material/button";
import { MajorsComponent } from "./majors/majors.component";
import { MajorStudentsComponent } from "./majors/major-students/major-students.component";
import { HttpClientModule } from "@angular/common/http";
import { CvComponent } from "./cv/cv.component"; // Ajoutez l'import pour CvComponent
import { MessageFormComponent } from "messageform/messageform.component";
import { modificationComponent } from "modification/modification.component";
import { InboxComponent } from "inbox/inbox.component";
import { UpdateComponent } from "./update/update.component";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    MajorsComponent,
    MajorStudentsComponent,
    CvComponent, 
    MessageFormComponent, 
    UpdateComponent,
    InboxComponent,
    modificationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatListModule,
    FormsModule,
    MatIconModule,
    MatButtonModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
