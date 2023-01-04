import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {UserListComponent} from "./user-list/user-list.component";
import {UserDetailsComponent} from "./user-details/user-details.component";
import {UserUpdateComponent} from "./user-update/user-update.component";

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
        component: UserListComponent,
      },
      {
        path: 'details/:id',
        component: UserDetailsComponent,
      },
      {
        path: 'update/:id',
        component: UserUpdateComponent,
      }
    ],
    // canActivate[AuthFilter]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
