package com.hva.helios.models.user.hour;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Class to set the available hours for that day
 */
@Entity
@Table(name = "availalability_hour")
public class Hour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0L;

    @JsonIgnore
    private String label;
    private boolean available;
    private String hourStart;
    private String hourEnd;

    protected Hour() {}

    public Hour(String label, boolean available, String start, String end) {
        this.label = label;
        this.available = available;
        this.hourStart = start;
        this.hourEnd = end;
    }

    public long getId() {
        return id;
    }

    public String getlabel() {
        return label;
    }

    public void setlabel(String label) {
        this.label = label;
    }

    public boolean isavailable() {
        return available;
    }

    public void setavailable(boolean available) {
        this.available = available;
    }

    public String getHourStart() {
        return hourStart;
    }

    public void setHourStart(String start) {
        this.hourStart = start;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String end) {
        this.hourEnd = end;
    }
}
