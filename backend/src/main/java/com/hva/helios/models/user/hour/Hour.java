package com.hva.helios.models.user.hour;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class to set the available hours for that day
 */
@Entity
@Table(name = "availalability_hour")
public class Hour {
    @Id
    @GeneratedValue
    private final long id = 0L;

    private String dayLabel;
    private boolean dayAvailable;
    private String hourStart;
    private String hourEnd;

    protected Hour() {}

    public Hour(String label, boolean available, String start, String end) {
        this.dayLabel = label;
        this.dayAvailable = available;
        this.hourStart = start;
        this.hourEnd = end;
    }

    public long getId() {
        return id;
    }

    public String getDayLabel() {
        return dayLabel;
    }

    public void setDayLabel(String label) {
        this.dayLabel = label;
    }

    public boolean isDayAvailable() {
        return dayAvailable;
    }

    public void setDayAvailable(boolean available) {
        this.dayAvailable = available;
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
