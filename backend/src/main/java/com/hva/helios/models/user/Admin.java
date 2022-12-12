package com.hva.helios.models.user;

import com.hva.helios.data.RightsData;
import com.hva.helios.models.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table
public class Admin extends User {
    @Id
    @GeneratedValue
    private long id = 0L;

    // TODO - Add a rights system
//    private ArrayList<String> rights;

    protected Admin() {}

    public Admin(String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone, String city, String zipCode, String address) {
        super(email, password, first_name, second_name, last_name, photo, bio, phone, city, zipCode, address);
    }

    @Override
    public long getId() {
        return id;
    }

    public int getUserType() {
        return 0;
    }
}
