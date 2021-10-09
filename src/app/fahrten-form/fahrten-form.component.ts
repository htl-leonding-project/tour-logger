import { Component, OnInit } from '@angular/core';

import {DataService} from '../data.service'
import { PeriodicElement} from "../data.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

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

  /*validator: any;
  validator = this.formBuilder.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    bootbez: ['', Validators.required],
    ort: ['', Validators.required],
    kmAnzahl: ['', Validators.required],
  });*/


  constructor(public dataServ:DataService) { };

  addEntry() {
    this.fullName = this.firstName + ' ' + this.lastName;
    this.dataServ.setElem(this.fullName, this.bootbez, this.ort, this.kmAnzahl);

    this.firstName = '';
    this.lastName = '';
    this.bootbez = '';
    this.ort = '';
    this.kmAnzahl = '';
  }



  ngOnInit(): void {
  }

}


