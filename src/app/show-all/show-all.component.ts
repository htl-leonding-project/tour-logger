import { Component, OnInit } from '@angular/core';
import {DataService, PeriodicElement} from '../data.service'
import {Observable} from "rxjs";

@Component({
  selector: 'app-show-all',
  templateUrl: './show-all.component.html',
  styleUrls: ['./show-all.component.css']
})
export class ShowAllComponent implements OnInit {

  public name: any;

  displayedColumns: string[] = ['name', 'bootbez', 'ort', 'kmAnzahl'];
  dataSource: any;

  constructor(public dataServ:DataService) {
    this.dataServ.getItems().subscribe(value => {
      this.dataSource = value;
    });
  }

  ngOnInit(): void {
  }

}
