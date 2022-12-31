package com.hva.helios.data;

import com.hva.helios.models.enums.EventType;
import com.hva.helios.models.user.Event;
import com.hva.helios.models.user.Specialist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventData {
    ArrayList<Event> events;

    Event event1 = new Event(null, new Date(), new Date(), "Meeting with Apple", EventType.WORK, "Starbucks", "LOREM IPSUM");
    Event event2 = new Event(null, new Date(), new Date(), "Family vacation", EventType.VACATION, "Starbucks", "LOREM IPSUM");
    Event event3 = new Event(null, new Date(), new Date(), "Work meeting with Leslie Alexander", EventType.WORK, "Starbucks", "LOREM IPSUM");
    Event event4 = new Event(null, new Date(), new Date(), "Meeting with Michelle Foster", EventType.WORK, "Costa Coffee at Behead", "LOREM IPSUM");
    Event event5 = new Event(null, new Date(), new Date(), "Meeting with Dries Vincent", EventType.OTHER, "Tim Hortons", "LOREM IPSUM");
    Event event6 = new Event(null, new Date(), new Date(), "Meeting with Lindsay Walton", EventType.WORK, "Silver-burn", "LOREM IPSUM");
    Event event7 = new Event(null, new Date(), new Date(), "Meeting with Leslie Alexander", EventType.OTHER, "The Glasgow Green", "LOREM IPSUM");

    public EventData(Specialist user) {
        event1.setUser(user);
        event2.setUser(user);
        event3.setUser(user);
        event4.setUser(user);
        event5.setUser(user);
        event6.setUser(user);
        event7.setUser(user);

        this.events = new ArrayList<>(List.of(event1, event2, event3, event4, event5, event6, event7));
    }

    public ArrayList<Event> getEvents() {
        return this.events;
    }
}
