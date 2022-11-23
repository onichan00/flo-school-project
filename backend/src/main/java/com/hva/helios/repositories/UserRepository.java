package com.hva.helios.repositories;

import com.hva.helios.models.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository implements CrudRepository<User> {

    private static ArrayList<User> users;
    protected static Admin admin;
    protected static String[] rights = {"canEditUsers", "canEditClients"};
    protected static Specialist specialist;
    protected static Language[] languages = {new Language(1,"java",3),new Language(2,"sql",2)};
    protected static Client client;


    public UserRepository(){
        admin = new Admin(1000,"admin@admin.nl","admin","admin","","admin","","dit is een admin account",0, rights);
        specialist = new Specialist(1004,"specialist@specialist.nl","specialist","specialist","","specialist","","dit is een specialist account",0,1,32,new Project[]{new Project("pannenkoeken bakkerij",0, LocalDate.now(),specialist,languages), new Project("koekenpannen maker",0, LocalDate.now(),specialist,languages)},languages);
        client = new Client(1001,"client@client.nl","client", "client", "","client","","dit is een client account",0,"clientwebsite.nl",new Project[]{new Project("pannenkoeken bakkerij",0, LocalDate.now(),specialist,languages)});

        users = new ArrayList<>(List.of(admin,client,specialist));


//        Specialist specialist2 =
//                new Specialist(
//                        1003
//                        ,"specialist@specialist.nl"
//                        ,"specialist"
//                        ,"specialist"
//                        ,""
//                        ,"specialist"
//                        ,""
//                        ,"dit is een specialist account"
//                        ,0
//                        ,1
//                        ,32
//                        ,new Project[]{
//                        new Project(
//                                "pannenkoeken bakkerij"
//                                ,0
//                                , LocalDate.now()
//                                ,specialist
//                                ,languages),
//                        new Project(
//                                "koekenpannen maker"
//                                ,0
//                                , LocalDate.now()
//                                ,specialist
//                                ,languages)}
//                        ,languages);


//        project =
//                new Project(
//                "pannenkoeken bakkerij",
//                0, LocalDate.now(),
//                new Specialist(1003
//                        ,"specialist@specialist.nl"
//                        ,"specialist"
//                        ,"specialist"
//                        ,""
//                        ,"specialist"
//                        ,""
//                        ,"dit is een specialist account"
//                        ,0
//                        ,1
//                        ,32
//                        , new Project[]{new Project("pannenkoeken bakkerij",0, LocalDate.now(),specialist,languages)}
//                        ,languages)
//                ,languages);
//
//        projects = new Project[]{project};
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }

    public ArrayList<User> getAllAdmins(){
        ArrayList<User> admins = new ArrayList<>();

        for (User user : users) {
            if (user.getClass().equals(Admin.class)){
                admins.add(user);
            }
        }
        return admins;
    }

    public ArrayList<User> getAllSpecialists(){
        ArrayList<User> specialists = new ArrayList<>();

        for (User user : users) {
            if (user.getClass().equals(Specialist.class)){
                specialists.add(user);
            }
        }
        return specialists;
    }

    public ArrayList<User> getAllClients(){
        ArrayList<User> clients = new ArrayList<>();

        for (User user : users) {
            if (user.getClass().equals(Client.class)){
                clients.add(user);
            }
        }
        return clients;
    }

    @Override
    public User saveItem(User item) {
        int index = users.indexOf(item);

        if (index == -1){
            users.add(item);
        } else {
            users.set(index,item);
        }
        return item;
    }

    public User deleteItem(User item) {
        int index = users.indexOf(item);

        User user = users.get(index);

        users.remove(index);

        return user;
    }

    @Override
    public User deleteById(int id) {
        User user = users.stream().filter(user1 -> id == user1.getId()).findAny().orElse(null);

        if (user != null){
            int index = users.indexOf(user);

            users.remove(index);
            return user;
        }
        return null;
    }

    @Override
    public User getById(int id) {
        User user = users.stream().filter(user1 -> id == user1.getId()).findAny().orElse(null);

        if (user != null){
            return user;

        }
        return null;
    }

}
