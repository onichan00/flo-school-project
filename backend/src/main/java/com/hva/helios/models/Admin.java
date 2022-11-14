package com.hva.helios.models;

public class Admin extends User {
    private String[] rights;

    public Admin(int user_id,String email, String password, String first_name, String second_name, String last_name, String photo, String bio, float phone ,String[] rights) {
        super(user_id,email,password,first_name,second_name,last_name,photo,bio,phone);
        this.rights = rights;
    }

    public String[] getRights() {
        return rights;
    }

    public void setRights(String[] rights) {
        this.rights = rights;
    }
}
