export default class UserSkill {
    id;
    level;
    skill;
    specialist;

    constructor(obj = null) {
        const isNull = obj === null;

        this.id = isNull ? 0 : obj.id;
        this.level = isNull ? 0 : obj.level;
        this.skill = isNull ? { id: 0 } : obj.skill;
        this.specialist = isNull ? { id: 0} : obj.specialist;
    }
}