import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import User from "./app/interfaces/User";


platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));

const users: User[] = [...Array(5)].map((el, index) => ({
  id: index,
  username: `user#${index+1}`,
  password: `pwd:user#${index+1}`,
  bornDate: new Date("1970-01-01"),
  lastTimeLogin: new Date(),
  roles: "ROLE_SIMPLE_USER",
}));
sessionStorage.setItem("users", JSON.stringify(users));
