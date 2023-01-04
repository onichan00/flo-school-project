package com.hva.helios.models.user.hour;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

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

    @Temporal(TemporalType.TIMESTAMP)
    private Date hourStart;
    @Temporal(TemporalType.TIMESTAMP)
    private Date hourEnd;

    protected Hour() {}

    public Hour(String label, boolean available, Date start, Date end) {
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

    public Date getStart() { return hourStart; }

    public void setHourStart(Date start) {
        this.hourStart = start;
    }

    public Date getEnd() { return hourEnd; }

    public void setHourEnd(Date end) {
        this.hourEnd = end;
    }
}
