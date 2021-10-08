import { Component, OnInit } from '@angular/core';

import {DataService} from '../data.service'
import { PeriodicElement} from "../data.service";

@Component({
  selector: 'app-fahrten-form',
  templateUrl: './fahrten-form.component.html',
  styleUrls: ['./fahrten-form.component.css']
})
export class FahrtenFormComponent implements OnInit {
  name: any;
  bootbez: any;
  ort: any;
  kmAnzahl: any;

  constructor(public dataServ:DataService) { }

  addEntry() {
    this.dataServ.setElem(this.name, this.bootbez, this.ort, this.kmAnzahl);
    console.log("TEST")
  }

  ngOnInit(): void {
  }

}
