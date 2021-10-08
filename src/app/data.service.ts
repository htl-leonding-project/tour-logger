import { Injectable } from '@angular/core';
import {Observable, of, Subject} from "rxjs";


export interface PeriodicElement {
  name: string;
  bootbez: string; // should be number - is string for testing
  ort: string;
  kmAnzahl: string; // should be number - is string for testing
}

@Injectable({
  providedIn: 'root'
})
export class DataService {

  fahrtenSubject: Subject<PeriodicElement[]>;

  constructor() {
    this.fahrtenSubject = new Subject<PeriodicElement[]>();
  }


  private fahrten:PeriodicElement[] = [
    { name: 'Bootsfahrer Jackson', bootbez: '6941', ort: 'Budapest', kmAnzahl: '12'}
  ];

  setElem(nameNew: string, bootbezNew: string, ortNew: string, kmAnzahlNew: string) {
    console.log(nameNew)
    console.log(bootbezNew)
    console.log(ortNew)
    console.log(kmAnzahlNew)
    this.fahrten.push({name: nameNew, bootbez: bootbezNew, ort: ortNew, kmAnzahl: kmAnzahlNew})
    //this.fahrten.push({name: 'Bootsfahrer Jackson', bootbez: '6941', ort: 'Budapest', kmAnzahl: '12'});
    console.log(this.fahrten);
    this.fahrtenSubject.next(this.fahrten);
  }

  getItems(): Observable<PeriodicElement[]> {
    return this.fahrtenSubject;
  }
}
