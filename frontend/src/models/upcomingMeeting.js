export default class UpcomingMeeting {
    title;
    start;
    end;
    location;
    description;
    type;

    constructor(obj = null) {
        const now = new Date();
        const endTime = new Date();

        now.setMinutes(0);
        endTime.setMinutes(0);
        endTime.setHours(endTime.getHours() + 1);

        this.title = obj !== null ? obj.title : "";
        this.start = obj !== null ? obj.start : now;
        this.end = obj !== null ? obj.end : endTime;
        this.location = obj !== null ? obj.location : "";
        this.description = obj !== null ? obj.description : "";
        this.type = obj !== null ? obj.type : -1;
    }
}