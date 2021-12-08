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

  constructor(public dataServ: DataService, private http: HttpClient) {
    // this.dataSource = [];



    this.dataSource = this.dataServ.fahrten;


    this.dataServ.getItems().subscribe(value => {
      this.dataSource = value;
    });
  }

  

  ngOnInit(): void {
  }

}
