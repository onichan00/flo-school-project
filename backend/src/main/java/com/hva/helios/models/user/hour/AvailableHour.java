package com.hva.helios.models.user.hour;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to keep track of the specialist available hours
 */
public class AvailableHour {
    int specialist;
    Map<String, Hour> days = new HashMap<>();

    public AvailableHour(int specialist) {
        this.specialist = specialist;

        this.days.put("monday", new Hour("monday", true, "09:00", "17:00"));
        this.days.put("tuesday", new Hour("tuesday", true, "09:00", "17:00"));
        this.days.put("wednesday", new Hour("wednesday", true, "09:00", "17:00"));
        this.days.put("thursday", new Hour("thursday", true, "09:00", "17:00"));
        this.days.put("friday", new Hour("friday", true, "09:00", "17:00"));
        this.days.put("saturday", new Hour("saturday", false, "09:00", "17:00"));
        this.days.put("sunday", new Hour("sunday", false, "09:00", "17:00"));
    }

    public int getSpecialist() {
        return specialist;
    }

    public void setSpecialist(int specialist) {
        this.specialist = specialist;
    }

    public Map<String, Hour> getDays() {
        return days;
    }

    public void setDays(Map<String, Hour> days) {
        this.days = days;
    }
}
