package com.hva.helios.models.user;

import com.hva.helios.data.RightsData;
import com.hva.helios.models.User;

import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<String> rights;
    private int userType = 0;

    public Admin(int user_id, String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone) {
        super(user_id, email, password, first_name, second_name, last_name, photo, bio, phone);

        this.rights = new RightsData().getRandomRights(3);
    }

    public Admin(int user_id, String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone, ArrayList<String> rights) {
        super(user_id, email, password, first_name, second_name, last_name, photo, bio, phone);
        this.rights = rights;
    }

    public ArrayList<String> getRights() {
        return rights;
    }

    public void setRights(ArrayList<String> rights) {
        this.rights = rights;
    }

    public int getUserType() {
        return userType;
    }
}
