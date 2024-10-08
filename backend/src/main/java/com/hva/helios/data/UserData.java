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
            "client",
            "client",
            "client",
            "client",
            "client",
            null,
            "Hallo ik ben Client",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            1L,
            new Client("testwebsite.nl")
    );

    User client2 = new User(
            "dennis.moesClient@hva.nl",
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
            "specialist",
            "specialist",
            "Henk",
            "",
            "Boer",
            null,
            "Hello I am specialist",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            2L,
            new Specialist(1,"Backend engineer", 2,null,null,null,null)
    );
    User specialist2 = new User(
            "specialist2@gmail.com",
            "specialist",
            "jan",
            "",
            "Willem",
            null,
            "Hello I am specialist",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            2L,
            new Specialist(1,"Backend engineer", 2,null,null,null,null)
    );
    User specialist3 = new User(
            "specialist3@gmail.com",
            "specialist",
            "joop",
            "",
            "bergen",
            null,
            "Hello I am specialist",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            2L,
            new Specialist(1,"Backend engineer", 2,null,null,null,null)
    );
    User specialist4 = new User(
            "specialist4@gmail.com",
            "specialist",
            "Germain",
            "",
            "Jansen",
            null,
            "Hello I am specialist",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            2L,
            new Specialist(1,"Backend engineer", 1,null,null,null,null)
    );

    User specialist5 = new User(
            "specialist5@gmail.com",
            "specialist1",
            "specialist1",
            "specialist1",
            "specialist1",
            null,
            "Hello I am specialist1",
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
