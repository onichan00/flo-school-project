package com.hva.helios.models;

import com.hva.helios.models.user.Admin;
import com.hva.helios.models.user.Client;
import com.hva.helios.models.user.Specialist;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user_table")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue
    private long id = 0L;
    private String email;
    private String password;
    private String first_name;
    private String second_name;
    private String last_name;
    private String photo;
    private String bio;
    private String phone;
    private String city;
    private String zipCode;
    private String address;
    private Long userType;
    @OneToOne
    Client client;
    @OneToOne
    Admin admin;
    @OneToOne
    Specialist specialist;

    protected User() {}

    public User(String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone, String city, String zipCode, String address, Long userType) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name = last_name;
        this.photo = photo;
        this.bio = bio;
        this.phone = phone;
        this.city = city;
        this.zipCode = zipCode;
        this.address = address;
        this.userType = userType;
    }
    public User(User user, Admin admin){
        User user2 = user;
        this.admin =admin;
    }

    public User(String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone, String city, String zipCode, String address, Long userType, Client client) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name = last_name;
        this.photo = photo;
        this.bio = bio;
        this.phone = phone;
        this.city = city;
        this.zipCode = zipCode;
        this.address = address;
        this.userType = userType;
        this.client = client;
    }

    public User(String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone, String city, String zipCode, String address, Long userType, Admin admin) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name = last_name;
        this.photo = photo;
        this.bio = bio;
        this.phone = phone;
        this.city = city;
        this.zipCode = zipCode;
        this.address = address;
        this.userType = userType;
        this.admin = admin;
    }

    public User(String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone, String city, String zipCode, String address, Long userType, Specialist specialist) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name = last_name;
        this.photo = photo;
        this.bio = bio;
        this.phone = phone;
        this.city = city;
        this.zipCode = zipCode;
        this.address = address;
        this.userType = userType;
        this.specialist = specialist;
    }

    public User(Long id, Long userType){
        this.userType = userType;
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }
}
