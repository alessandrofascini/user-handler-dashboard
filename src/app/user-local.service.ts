import { Injectable } from '@angular/core';
import {UserServiceService} from "./user-service.service";
import User from "./interfaces/User";
import {observable, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserLocalService extends UserServiceService {
  users: User[] = [];
  constructor() {
    super();
    // @ts-ignore
    this.users = JSON.parse(sessionStorage.getItem("users"));
  }

  delete(user: User): Observable<User> {
    return new Observable<User>(observer => {
      observer.next();
    });
  }

  findAll(): Observable<Array<User>> {
    return new Observable<Array<User>>(observer => {
      observer.next(this.users);
    });
  }

  findById(id: number): Observable<User> {
    return new Observable<User>(observer => {
      for(const user of this.users) {
        if(user.id == id) {
          observer.next(user);
          observer.complete();
        }
      }
      observer.error("User not found");
    });
  }

  update(user: User): Observable<User> {
    return new Observable<User>(observer => {

    });
  }
}
