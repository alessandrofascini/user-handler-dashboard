import { Injectable } from '@angular/core';
import {UserLocalService} from "./user-local.service";
import {UserInterfaceService} from "./user-interface.service";
import {Observable} from "rxjs";
import User from "./interfaces/User";

@Injectable({
  providedIn: 'root'
})
export class FactoryService extends UserInterfaceService {
  service: UserInterfaceService;
  constructor(private localService: UserLocalService) {
    super();
    this.service = localService;
  }

  getService() {
    return this.service;
  }

  delete(user: User): Observable<User> {
    return this.service.delete(user);
  }

  findAll(): Observable<Array<User>> {
    return this.service.findAll();
  }

  findById(id: number): Observable<User> {
    return this.service.findById(id);
  }

  update(user: User): Observable<User> {
    return this.service.update(user);
  }

}
