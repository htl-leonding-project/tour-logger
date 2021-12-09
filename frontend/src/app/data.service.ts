import { Injectable } from '@angular/core';
import { Observable, of, Subject} from "rxjs";
import {HttpClient} from "@angular/common/http";

const BASE_URL: string = 'http://localhost:8080/api'

/*export interface FahrtenInterface {
  name: string;
  bootbez: string; // should be number - is string for testing
  ort: string;
  kmAnzahl: string; // should be number - is string for testing
}*/

export interface FahrtenInterface {
  boat: string;
  destination: string;
  distance: string;
  firstName: string;
  lastName: string;

}

@Injectable({
  providedIn: 'root'
})
export class DataService {

  fahrtenSubject: Subject<FahrtenInterface[]>;
  readonly fahrten: FahrtenInterface[];

  constructor(private http: HttpClient) {
    this.fahrtenSubject = new Subject<FahrtenInterface[]>();
    this.fahrten = [];
  }

  setElem(nameNew: string, bootbezNew: string, ortNew: string, kmAnzahlNew: string) {

    //console.log({nameNew, bootbezNew, ortNew, kmAnzahlNew});

    //const fahrt = {name: nameNew, bootbez: bootbezNew, ort: ortNew, kmAnzahl: kmAnzahlNew};
    const fahrt = {boat: bootbezNew,
      destination: ortNew,
      distance: kmAnzahlNew,
      firstName: nameNew,
      lastName: nameNew};

    this.fahrten.push(fahrt);

    this.http.post('localhost:8080/api/add', fahrt).subscribe(value => {
      console.log(value);
    });


    //console.log(this.fahrten);

    this.fahrtenSubject.next(this.fahrten);

  }

  getItems(): Observable<FahrtenInterface[]> {

    console.log(this.http.get<FahrtenInterface[]>(`${BASE_URL}/findAll`));
    return this.http.get<FahrtenInterface[]>(`${BASE_URL}/findAll`);

  }
}
