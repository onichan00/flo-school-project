export default class UpcomingMeeting {
    id;
    user;
    project;
    start;
    end;
    title;
    eventType;
    location;
    description;
    accepted;

    constructor(obj = null) {
        const isNull = obj === null;

        const today = new Date();

        const startTime = new Date(today.getFullYear(), today.getMonth(), today.getDate(), 9, 0, 0);
        const endTime = new Date(today.getFullYear(), today.getMonth(), today.getDate(), 17, 0, 0);

        this.id = isNull ? 0 : obj.id;
        this.user = isNull ? { id: 0 } : obj.user;
        this.project = isNull ? { id: 0 } : obj.project;

        this.start = isNull ? startTime : obj.start;
        this.end = isNull ? endTime : obj.end;

        this.title = isNull ? "" : obj.title;
        this.eventType = isNull ? "" : obj.eventType;
        this.location = isNull ? "" : obj.location;
        this.description = isNull ? "" : obj.description;
        this.accepted = isNull ? 0 : obj.accepted;
    }


}