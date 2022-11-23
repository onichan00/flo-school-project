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
    private String phone;

    public User(int id, String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name = last_name;
        this.photo = photo;
        this.bio = bio;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
