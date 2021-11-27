import { Component, OnInit } from '@angular/core';

import {DataService} from '../data.service'
import { PeriodicElement} from "../data.service";
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
  firstName: any;
  lastName: any;
  bootbez: any;
  ort: any;
  kmAnzahl: any;
  fullName: any;

  myControl = new FormControl();
  options: string[] = ['Marie - Therese',
    'Luggy',
    'Wolf',
    '20er',
    'Anna & Niki',
    'Montrial',
    'Silberpfeil',
    'Hartl Privat',
    'Andrea',
    'ON Filippi',
    'Lisa',
    'Rudi',
    'Speedy',
    'Donaukiesel',
    'Morgensonne',
    'Ottensheim',
    'Theresa',
    'Moewe',
    'Gruen',
    'Grein',
    'Dovian',
    'Bürgermeister',
    'Niki',
    'Optimus Prime',
    'ASVOE-OOE',
    'Alex',
    'Rainer',
    'NoRiskNoFun',
    'Rosinante',
    'Yellow Submarine',
    'Rapunzel',
    'Hanni',
    'Sputnik',
    '59',
    'Schneckenpost',
    'Eva Koenig',
    'Seebaer',
    'Luggi',
    '41',
    'Smilla',
    'Hermi',
    'Schwarzer Adler',
    'Nikolaus',
    'Wolfgang',
    'Men at work',
    'Traunstein',
    'Luggi'];




  // @ts-ignore
  filteredOptions: Observable<string[]>;

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

  ngOnInit() {
    this.filteredOptions = this.myControl.valueChanges.pipe(
        startWith(''),
        map(value => this._filter(value)),
    );
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }

}


