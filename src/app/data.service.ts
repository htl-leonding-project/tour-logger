import { Injectable } from '@angular/core';
import {Observable, of, Subject} from "rxjs";
import {HttpClient} from "@angular/common/http";


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
  readonly fahrten: PeriodicElement[];

  constructor(private http: HttpClient) {
    this.fahrtenSubject = new Subject<PeriodicElement[]>();
    this.fahrten = [];
  }

  setElem(nameNew: string, bootbezNew: string, ortNew: string, kmAnzahlNew: string) {
    console.log({nameNew, bootbezNew, ortNew, kmAnzahlNew});

    const fahrt = {name: nameNew, bootbez: bootbezNew, ort: ortNew, kmAnzahl: kmAnzahlNew};

    this.fahrten.push(fahrt);

    this.http.post('', fahrt).subscribe(value => {
      console.log(value);
    });

    console.log(this.fahrten);

    this.fahrtenSubject.next(this.fahrten);
  }

  getItems(): Observable<PeriodicElement[]> {
    return this.fahrtenSubject;
  }
}
