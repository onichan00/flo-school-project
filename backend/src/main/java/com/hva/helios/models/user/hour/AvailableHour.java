package com.hva.helios.models.user.hour;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hva.helios.views.Views;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to keep track of the specialist available hours
 */
@Entity
@Table
public class AvailableHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private long id = 0L;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonView(Views.Public.class)
    @JsonSerialize(using = Views.PublicSerializer.class)
    private Map<String, Hour> days = new HashMap<>();

    public AvailableHour() {
        Calendar startCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();

        startCal.set(Calendar.HOUR_OF_DAY, 9);
        endCal.set(Calendar.HOUR_OF_DAY, 17);

        Date start = startCal.getTime();
        Date end = endCal.getTime();

        this.days.put("monday", new Hour("Maandag", true, start, end));
        this.days.put("tuesday", new Hour("Dinsdag", true, start, end));
        this.days.put("wednesday", new Hour("Woensdag", true, start, end));
        this.days.put("thursday", new Hour("Donderdag", true, start, end));
        this.days.put("friday", new Hour("Vrijdag", true, start, end));
        this.days.put("saturday", new Hour("Zaterdag", false, start, end));
        this.days.put("sunday", new Hour("Zondag", false, start, end));
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
