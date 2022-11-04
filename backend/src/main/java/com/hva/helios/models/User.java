package com.hva.helios.models;

public class User {
    private int id;
    private String email;
    private String password;
    private String first_name;
    private String second_name;
    private String last_name;
    private String photo;
    private String bio;
    private int phone;

    private ProfileExtension profileExtension;

    public User(int id, String email, String password, String first_name, String second_name, String last_name, String photo, String bio, int phone, ProfileExtension profileExtension) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name = last_name;
        this.photo = photo;
        this.bio = bio;
        this.phone = phone;
        this.profileExtension = profileExtension;
    }
}
