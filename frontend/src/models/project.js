export class project{
    // dit is tot we db hebben tijdelijk
    static names = ["Yoga app", "Shopping site", "Streaming site", "Todolist app", "Bedrijfs applicatie", "Voorraad systeem"]
    static skills = ["Java", "Python", "C#", "C++", "Javascript", "Vue"]
    static specialists = ["Jan Hendrik", "Dennis Moes", "Maajid Saidy", "Illias Opdebeat", "Frank Young", "Simone Warmepa"]
    static creators = ["dennismoes@icloud.com", "maajidsaidy@gmail.com", "simonvriesema@hotmail.com", "frankoud@yahoo.com", "illiasopdebeat@gmail.com", "janhendrikson@florijn.nl"]

    constructor(id,name,status,skills,created,specialists, createdBy){
        this.id = id
        this.name = name
        this.status = status
        this.skills = skills
        this.created = created
        this.specialists = specialists
        this.createdBy = createdBy
    }

    static createSampleProject(id = 0){
        let randomizer = Math.floor(Math.random() * 6)

        let projectName = this.names[randomizer]
        let projectSpecialist = [this.specialists[randomizer],this.specialists[randomizer],this.specialists[randomizer]]
        let projectSkills = [this.skills[randomizer],this.skills[randomizer],this.skills[randomizer]]
        let status = 1
        let createdBy = this.creators[randomizer]

        let today = new Date();
        let dd = String(today.getDate()).padStart(2, '0');
        let mm = String(today.getMonth() + 1).padStart(2, '0');
        let yyyy = today.getFullYear();
        let created = mm + '/' + dd + '/' + yyyy;

        return new project(id,projectName,status,projectSkills,created,projectSpecialist,createdBy)
    }

}