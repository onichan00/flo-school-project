class hourPart {
  constructor(label, available, start, end) {
    this.label = label;
    this.available = available;
    this.start = start;
    this.end = end;
  }
}

export default class availableHour {
  constructor(object) {
    this.specialist = object.specialist;
    this.hours = object.hours;
  }

  static setHours(hours) {
    this.hours = hours;
  }
}