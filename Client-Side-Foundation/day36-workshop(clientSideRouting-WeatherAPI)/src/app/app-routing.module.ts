import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DisplayComponent } from './components/display/display.component';
import { DetailsComponent } from './components/details/details.component';

const routes: Routes = [
  {path:"display", component: DisplayComponent},
  {path:"details/:city", component: DetailsComponent},
  // {path:"**", pathMatch:"full", redirectTo:"display"},
  {path:"**", pathMatch:"full", redirectTo:"/"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
