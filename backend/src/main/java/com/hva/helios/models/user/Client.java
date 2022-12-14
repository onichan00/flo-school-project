package com.hva.helios.models.user;

import com.hva.helios.data.ProjectData;
import com.hva.helios.models.Project;
import com.hva.helios.models.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0L;

    private String website;
    @ManyToMany
    private List<Project> projects;

    @OneToOne
    private User user;


    protected Client() {}

    public Client(User user, String website) {
        ;

        this.user = user;
        this.website = website;
//        this.projects = projects;
    }

    public Client(User user){
        this.user = user;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
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
