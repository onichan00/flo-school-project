package com.hva.helios.models.user.hour;

/**
 * Class to set the available hours for that day
 */
public class Hour {
    private String label;
    private boolean available;
    private String start;
    private String end;

    public Hour(String label, boolean available, String start, String end) {
        this.label = label;
        this.available = available;
        this.start = start;
        this.end = end;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
