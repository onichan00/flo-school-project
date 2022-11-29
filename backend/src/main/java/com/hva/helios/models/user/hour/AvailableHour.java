package com.hva.helios.models.user.hour;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to keep track of the specialist available hours
 */
@Entity
@Table
public class AvailableHour {
    @Id
    @GeneratedValue
    private long id = 0L;

    @OneToMany(cascade = CascadeType.ALL)
    private Map<String, Hour> days = new HashMap<>();

    public AvailableHour() {
        this.days.put("monday", new Hour("monday", true, "09:00", "17:00"));
        this.days.put("tuesday", new Hour("tuesday", true, "09:00", "17:00"));
        this.days.put("wednesday", new Hour("wednesday", true, "09:00", "17:00"));
        this.days.put("thursday", new Hour("thursday", true, "09:00", "17:00"));
        this.days.put("friday", new Hour("friday", true, "09:00", "17:00"));
        this.days.put("saturday", new Hour("saturday", false, "09:00", "17:00"));
        this.days.put("sunday", new Hour("sunday", false, "09:00", "17:00"));
    }

    public long getId() {
        return id;
    }

    public Map<String, Hour> getDays() {
        return days;
    }

    public void setDays(Map<String, Hour> days) {
        this.days = days;
    }
}
