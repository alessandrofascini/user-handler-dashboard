import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {DashboardComponent} from "./dashboard/dashboard.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'users',
    component: DashboardComponent,
    children: [
      {
        path: 'list',
      },
      {
        path: 'details/:id',
      },
      {
        path: 'update/:id',
      }
    ],
    redirectTo: '/dashboard/user-list/'
    // canActivate[AuthFilter]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
