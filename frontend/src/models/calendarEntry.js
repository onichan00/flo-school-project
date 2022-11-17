export default class calendarEntry {
  constructor(object) {
    this.id = object.id;
    this.project = object.project;
    this.start = object.start;
    this.end = object.end;
  }

  static isFilledIn() {
    const project = this.project !== null;
    const start = this.start !== null;
    const end = this.end !== null;

    return project && start && end;
  }
}