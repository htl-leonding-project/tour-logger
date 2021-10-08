import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import {FahrtenFormComponent} from "./fahrten-form/fahrten-form.component";
import {ShowAllComponent} from "./show-all/show-all.component";

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'app-fahrten-form' },
  { path: 'new', component: FahrtenFormComponent },
  { path: 'show', component: ShowAllComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
