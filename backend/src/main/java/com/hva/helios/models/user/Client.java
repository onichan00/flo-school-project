package com.hva.helios.models.user;

import javax.persistence.*;

@Entity
@Table
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0L;

    private String website;

    public Client() {

    }

    public Client(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
