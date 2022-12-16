package com.hva.helios.models.user;

import com.hva.helios.data.RightsData;
import com.hva.helios.models.User;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0L;

//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;

//    public User getUser() {
//        return user;
//    }

//    public void setUser(User user) {
//        this.user = user;
//    }

    // TODO - Add a rights system
//    private ArrayList<String> rights;


    public Admin() {

    }

//    public Admin(User user) {
//        this.user = user;
//    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
