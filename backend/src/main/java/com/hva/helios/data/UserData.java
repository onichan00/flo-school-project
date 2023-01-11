package com.hva.helios.data;

import com.hva.helios.models.User;
import com.hva.helios.models.user.Admin;
import com.hva.helios.models.user.Client;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.utilities.Authentication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserData {
    ArrayList<User> clients;
    ArrayList<User> Admins;
    Client clientData = new Client("https://www.google.com");
    Authentication authentication;

    User client1 = new User(
            "simonvriesema@outlook.com",
            "Kaassoufle123$",
            "Simon",
            "",
            "Vriesema",
            null,
            "Hallo ik ben Simon",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            1L,
            new Client("testwebsite.nl")
    );

    User client2 = new User(
            "simonvriesema@outlook.com",
            "Kaassoufle123$",
            "Maajid",
            "",
            "Saidy",
            null,
            "Hello I am Maajid",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            1L,
            new Client("websitetest.nl")
    );

    User admin1 = new User(
            "dennis.moes1@hva.nl",
            "password123",
            "yahia",
            "",
            "elsherbini",
            null,
            "Hello I am Yahia",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            0L
    );

    User admin2 = new User(
            "admin",
            "admin",
            "admin",
            "admin",
            "admin",
            null,
            "Hello I am admin",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            0L
    );

    User specialist1 = new User(
            "simon.vriesema@icloud.com",
            "Kaassoufle123$",
            "Frank",
            "",
            "Oud",
            null,
            "Hello I am Frank",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            2L,
            new Specialist(1,"Backend engineer", 2,null,null,null,null)
    );
    User specialist2 = new User(
            "simon.vriesema@hva.nl",
            "Kaassoufle123$",
            "Jan",
            "",
            "Willem",
            null,
            "Hello I am Jan",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            2L,
            new Specialist(1,"Backend engineer", 2,null,null,null,null)
    );
    User specialist3 = new User(
            "maajid.saidy@hva.nl",
            "Kaassoufle123$",
            "Maajid",
            "",
            "Saidy",
            null,
            "Hello I am Maajid",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            2L,
            new Specialist(1,"Backend engineer", 2,null,null,null,null)
    );
    User specialist4 = new User(
            "frank.oud@hva.nl",
            "Kaassoufle123$",
            "Frank",
            "",
            "Oud",
            null,
            "Hello I am Frank",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            2L,
            new Specialist(1,"Backend engineer", 1,null,null,null,null)
    );

    User specialist5 = new User(
            "specialist",
            "Kaassoufle123$",
            "Dennis",
            "",
            "Moes",
            null,
            "Hello I am Dennis",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            2L,
            new Specialist(1,"Backend engineer", 1,null,null,null,null)
    );

//    User specialist3 = new User(
//            "specialist2",
//            "specialist2",
//            "specialist2",
//            "specialist2",
//            "specialist2",
//            null,
//            "Hello I am waiting for approval",
//            "+31 6 12345678",
//            "Amsterdam",
//            "1091 GH",
//            "Wibautstraat 3b",
//            2L,
//            new Specialist(1,"Backend engineer", 2,null,null,null,null)
//    );

    public UserData() {
        authentication = new Authentication();
    }

    public ArrayList<User> getClients() {
        client1.setPassword(authentication.hash(client1.getPassword()));
        client2.setPassword(authentication.hash(client2.getPassword()));

        return new ArrayList<>(List.of(client1,client2));
    }

    public ArrayList<User> getAdmins() {
        admin1.setPassword(authentication.hash(admin1.getPassword()));
        admin2.setPassword(authentication.hash(admin2.getPassword()));

        return new ArrayList<>(List.of(admin1,admin2));
    }

    public ArrayList<User> getSpecialists() {
        specialist1.setPassword(authentication.hash(specialist1.getPassword()));
        specialist2.setPassword(authentication.hash(specialist2.getPassword()));
        specialist3.setPassword(authentication.hash(specialist3.getPassword()));
        specialist4.setPassword(authentication.hash(specialist4.getPassword()));
        specialist5.setPassword(authentication.hash(specialist5.getPassword()));

        return new ArrayList<>(List.of(specialist1, specialist2, specialist3, specialist4, specialist5));
    }
}
