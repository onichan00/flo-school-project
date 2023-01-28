package com.hva.helios.models.user;

import com.hva.helios.models.User;

import javax.persistence.*;

@Entity
@Table
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0L;

    @OneToOne
    private User user;

    private String website;

    public Client() {

    }

    public boolean associateUser(User user) {
        setUser(user);
        return true;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
