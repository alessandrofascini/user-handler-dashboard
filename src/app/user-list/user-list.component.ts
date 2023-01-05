import { Component } from '@angular/core';
import {FactoryService} from "../factory.service";
import User from "../interfaces/User";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent {

  users: User[] = [];
  constructor(private service: FactoryService, private router: Router) {
    this.refreshList();
  }

  view(id: number) {
    this.router.navigateByUrl("/users/details/" + id).then();
  }

  edit(id: number) {
    this.router.navigateByUrl("/users/update/" + id).then();
  }

  delete(id: number) {
    this.service.findById(id)
      .subscribe((user) => {
        console.log(user);
        this.service.delete(user).subscribe(this.refreshList);
      });
  }

  refreshList() {
    this.service.findAll().subscribe({
      next: (users) => {
        this.users = users;
      }
    })
  }
}
