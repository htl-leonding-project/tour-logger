import { Component, OnInit } from '@angular/core';
import {BootInterface, DataService, FahrtenInterface} from '../data.service'
import {Observable} from "rxjs";
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-show-all',
  templateUrl: './show-all.component.html',
  styleUrls: ['./show-all.component.css']
})
export class ShowAllComponent implements OnInit {

  public name: any;
  fahrten: FahrtenInterface[];


  constructor(public dataServ: DataService) {
    this.fahrten = this.dataServ.fahrten;

    this.dataServ.getItems().subscribe(value => {
      this.fahrten = value;
    });

  }

  ngOnInit(): void {
  }

  delete(fahrt: FahrtenInterface) {
    if(confirm(`Willst du die Fahrt nach ${fahrt.destination} wirklich löschen?`)) {
      console.log(fahrt)
      this.dataServ.deleteItem(fahrt.id!);
      this.fahrten.splice(this.fahrten.indexOf(fahrt), 1)
    }
    //alert(`Fahrt von ${fahrt.firstName} ${fahrt.lastName} gelöscht!`)
  }
}
