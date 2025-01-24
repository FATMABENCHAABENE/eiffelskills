import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from 'models/model.model';
import { Service } from 'services/service.service';

@Component({
  selector: 'teachershoweval',
  standalone: true,
  imports: [],
  templateUrl: './teachershoweval.component.html',
  styleUrl: './teachershoweval.component.scss'
})
export class TeachershowevalComponent implements OnInit {
  idModule: number=0;
  moduleDescription: string="";
  students: Users[]= [];

  ngOnInit(): void {
    
  }

}
