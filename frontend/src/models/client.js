export default class client {
  constructor(object) {
    this.id = object.email;
    this.fName = object.first_name;
    this.sName = object.second_name;
    this.lName = object.last_name;
    this.photo = object.photo;
    this.bio = object.bio;
    this.company = object.company;
    this.phone = object.phone;
    this.projects = object.projects;
    this.website = object.website;
  }
}