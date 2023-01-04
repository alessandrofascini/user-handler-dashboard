export default interface User {
  id: number,
  username: string,
  password: string,
  bornDate: Date,
  roles: string,
  lastTimeLogin: Date,
}
