export default class project{
    constructor(object){
        this.id = object.id;
        this.name = object.name;
        this.status = object.status;
        this.created = new Date(object.created);
        this.client = object.client;
        this.specialists = object.specialists;
    }

    static addToSpecialists = (specialist) => {
        this.specialists.push(specialist);
    }
}