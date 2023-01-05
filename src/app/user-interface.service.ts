import { Injectable } from '@angular/core';
import User from 'src/app/interfaces/User';
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export abstract class UserInterfaceService {
  public abstract findAll(): Observable<Array<User>>;
  public abstract findById(id: number): Observable<User>;
  public abstract update(user: User): Observable<User>;
  public abstract delete(user: User): Observable<User>;
}
