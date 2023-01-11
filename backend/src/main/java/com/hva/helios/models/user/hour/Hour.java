package com.hva.helios.models.user.hour;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.hva.helios.views.Views;

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
    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String label;

    @JsonView(Views.Public.class)
    private boolean available;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(Views.Public.class)
    private Date hourStart;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(Views.Public.class)
    private Date hourEnd;

    protected Hour() {}

    public Hour(String label, boolean available, Date start, Date end) {
        this.label = label;
        this.available = available;
        this.hourStart = start;
        this.hourEnd = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getHourStart() {
        return hourStart;
    }

    public void setHourStart(Date hourStart) {
        this.hourStart = hourStart;
    }

    public Date getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(Date hourEnd) {
        this.hourEnd = hourEnd;
    }
}
