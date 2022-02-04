import { Component, OnInit } from '@angular/core';
import {DataService, FahrtenInterface} from '../data.service'
import {Observable} from "rxjs";
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-show-all',
  templateUrl: './show-all.component.html',
  styleUrls: ['./show-all.component.css']
})
export class ShowAllComponent implements OnInit {

  public name: any;
  dataSource: FahrtenInterface[];


  constructor(public dataServ: DataService,
              private http: HttpClient) {
    this.dataSource = this.dataServ.fahrten;

    this.dataServ.getItems().subscribe(value => {
      this.dataSource = value;
    });
  }

  ngOnInit(): void {
  }

  delete(fahrt: FahrtenInterface) {
    if(confirm(`Willst du die Fahrt von ${fahrt.firstName} ${fahrt.lastName} nach ${fahrt.destination} wirklich löschen?`)) {
      console.log(fahrt)
      this.dataServ.deleteItem(fahrt.id!);
      this.dataSource.splice(this.dataSource.indexOf(fahrt), 1)
    }
    //alert(`Fahrt von ${fahrt.firstName} ${fahrt.lastName} gelöscht!`)
  }
}
