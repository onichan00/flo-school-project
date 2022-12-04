package com.hva.helios.models.user;

import com.hva.helios.data.ProjectData;
import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Client extends User {

    @Id
    @GeneratedValue
    private long id = 0L;

    private String website;
    @ManyToMany
    private List<Project> projects;

    protected Client() {}

    public Client(String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone, String city, String zipCode, String address, String website) {
        super(email, password, first_name, second_name, last_name, photo, bio, phone, city, zipCode, address);

        this.website = website;
//        this.projects = projects;
    }

    public Client(String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone, String city, String zipCode, String address) {
        super(email, password, first_name, second_name, last_name, photo, bio, phone, city, zipCode, address);

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

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
