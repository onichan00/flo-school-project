export default class Skill {
  name;
  level;

  constructor(obj = null) {
    this.name = obj !== null ? obj.name : "";
    this.level = obj !== null ? obj.level : 0;
  }
}