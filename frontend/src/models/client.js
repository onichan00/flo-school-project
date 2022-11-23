export default class client {
  constructor(object) {
    this.id = object.id;
    this.first_name = object.first_name;
    this.second_name = object.second_name;
    this.last_name = object.last_name;
    this.photo = object.photo;
    this.bio = object.bio;
    this.company = object.company;
    this.phone = object.phone;
    this.projects = object.projects;
    this.website = object.website;
  }
}