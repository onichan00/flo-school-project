package com.hva.helios.models.user;

import com.hva.helios.models.User;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Event {
    @Id
    @GeneratedValue()
    private long id = 0L;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    protected Event() {}

    public Event(User user) {
        this.user = user;

    }
}
