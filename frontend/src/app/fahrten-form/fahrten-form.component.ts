import { Component, OnInit } from '@angular/core';

import {BootInterface, DataService} from '../data.service'
import { FahrtenInterface} from "../data.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';

@Component({
  selector: 'app-fahrten-form',
  templateUrl: './fahrten-form.component.html',
  styleUrls: ['./fahrten-form.component.css']
})
export class FahrtenFormComponent implements OnInit {
  driverNames: string[];
  boot: any;
  ort: any;
  kmAnzahl: any;
  driversArray: any;
  showDriversTitle: boolean

  boote: BootInterface[]
  fahrtForm: any

  boatForm = new FormControl();

  // @ts-ignore
  filteredOptions: Observable<string[]>;




  constructor(public dataServ:DataService) {
    this.driverNames = []
    this.showDriversTitle = false
    this.boote = this.dataServ.boote;

    this.dataServ.getBoats().subscribe(value => {
      this.boote = value;
    })
  };




  addEntry() {
    console.log(this.boote);
    for (let b of this.boote) {
      if (this.boot === b.name) {
        this.boot = b
      }
    }
    this.boot.id = null;
    this.dataServ.setFahrt(this.driverNames, this.boot, this.ort, this.kmAnzahl);

    this.driverNames = [];
    this.boot = null;
    this.ort = '';
    this.kmAnzahl = '';
    this.createDriverFields()

  }

  ngOnInit() {

  }

  createDriverFields() {
    for (let b of this.boote) {
      if (this.boot === b.name) {
        this.showDriversTitle = true
        this.driversArray = Array.from({length: b.nrOfSeats}, (_, i) => i + 1)
      }
      if (this.boot === null) {
        this.showDriversTitle = false
        this.driversArray = []
      }
    }
    console.log(this.boot)
  }
}


