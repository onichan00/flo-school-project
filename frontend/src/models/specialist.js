export default class specialist {
  constructor(object) {
    this.id = object.id;
    this.email = object.email;
    this.first_name = object.first_name;
    this.second_name = object.second_name;
    this.last_name = object.last_name;
    this.photo = object.photo;
    this.bio = object.bio;
    this.company = object.company;
    this.phone = object.phone;
    this.address = object.address;
    this.zipCode = object.zipCode;
    this.city = object.city;
    this.specialistType = object.specialistType;
  }
}