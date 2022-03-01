import { Injectable } from '@angular/core';
import { Observable, of, Subject} from "rxjs";
import {HttpClient} from "@angular/common/http";

const BASE_URL: string = 'http://localhost:8080'

/*export interface FahrtenInterface {
  name: string;
  bootbez: string; // should be number - is string for testing
  ort: string;
  kmAnzahl: string; // should be number - is string for testing
}*/

export interface FahrtenInterface {
  id: number|null;
  boat: BootInterface;
  destination: string;
  distance: string;
  drivers: string[];
}

export interface BootInterface{
  id: number|null;
  name: String;
  nrOfSeats: number;
  typeSeats: String;
}

@Injectable({
  providedIn: 'root'
})
export class DataService {

  fahrtenSubject: Subject<FahrtenInterface[]>;
  readonly fahrten: FahrtenInterface[];
  readonly boote: BootInterface[];

  constructor(private http: HttpClient) {
    this.fahrtenSubject = new Subject<FahrtenInterface[]>();
    this.fahrten = [];
    this.boote = [];
  }

  setFahrt(driverNames: string[], boot: BootInterface, ortNew: string, kmAnzahlNew: string) {

    //const fahrt = {name: nameNew, bootbez: bootbezNew, ort: ortNew, kmAnzahl: kmAnzahlNew};
    const fahrt = {
      id: null,
      boat: boot,
      destination: ortNew,
      distance: kmAnzahlNew,
      drivers: driverNames};

      this.fahrten.push(fahrt);
      console.log(fahrt)

      this.http.post(`${BASE_URL}/tours/add`, fahrt).subscribe(value => {
        console.log(value);
      }
    );


    //console.log(this.fahrten);

    this.fahrtenSubject.next(this.fahrten);

  }

  getItems(): Observable<FahrtenInterface[]> {
    console.log(this.http.get<FahrtenInterface[]>(`${BASE_URL}/tours/findAll`));
    return this.http.get<FahrtenInterface[]>(`${BASE_URL}/tours/findAll`);
  }

  deleteItem(id: Number){
    this.http.delete(`${BASE_URL}/tours/deletebyid/${id}`)
        .subscribe({
          next: data => {
            console.log(`Fahrt #${id} ist gelöscht`)
          },
          error: error => {
            console.error('There was an error!', error);
          }
        });
  }

  getBoats(): Observable<BootInterface[]>{
    return this.http.get<BootInterface[]>(`${BASE_URL}/boats`);
  }
}
