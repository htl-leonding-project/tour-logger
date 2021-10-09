import { Component, OnInit } from '@angular/core';

import {DataService} from '../data.service'
import { PeriodicElement} from "../data.service";

@Component({
  selector: 'app-fahrten-form',
  templateUrl: './fahrten-form.component.html',
  styleUrls: ['./fahrten-form.component.css']
})
export class FahrtenFormComponent implements OnInit {
  firstName: any;
  lastName: any;
  bootbez: any;
  ort: any;
  kmAnzahl: any;
  fullName: any;

  constructor(public dataServ:DataService) { };

  addEntry() {
    this.fullName = this.firstName + ' ' + this.lastName;
    this.dataServ.setElem(this.fullName, this.bootbez, this.ort, this.kmAnzahl);

    this.firstName = '';
    this.bootbez = '';
    this.ort = '';
    this.kmAnzahl = '';
  }

  ngOnInit(): void {
  }

}
