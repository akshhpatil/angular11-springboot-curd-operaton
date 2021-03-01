import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudListComponent } from './stud-list/stud-list.component';
import { AddComponent } from './add/add.component';
import { UpdateComponent } from './update/update.component';


const routes: Routes = [
  { path: '', redirectTo: 'stud', pathMatch: 'full' },
  { path: 'stud', component: StudListComponent },
  { path: 'add', component:  AddComponent  },
  { path: 'update/:id', component: UpdateComponent  },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
