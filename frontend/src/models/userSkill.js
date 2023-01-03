export default class UserSkill {
    constructor(obj = null) {
        this.id = obj !== null ? obj.id : null;
        this.level = obj !== null ? obj.level : 0;
        this.skill = obj !== null ? obj.skill : 0;
        this.specialist = obj !== null ? obj.specialist : {};
    }
}