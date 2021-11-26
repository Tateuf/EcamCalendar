package com.ecam.Calendar.model;

import java.util.ArrayList;
import java.util.List;
import com.ecam.Calendar.db.dbUser;

public class User {
    private String name;
    private String firstname;
    private final String noma;
    private final String role;

    public User(String name, String firstname, String noma, String role) {
        this.name = name;
        this.firstname = firstname;
        this.noma = noma;
        this.role = role;
    }

    public static boolean subscribe(String noma, String UEcode) {
        return dbUser.subscribe(noma,UEcode);
    }

    public static List<Lecture> getLectures(String noma) {
        return dbUser.getLectures(noma);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getNoma() {
        return noma;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", noma='" + noma + '\'' +
                ", role='" + role + '\'' +
                '}';
    }


    public static List<User> read(String code) {
        //TODO link to database
        //Database.readLecture()
        return new ArrayList<User>();
    }

}
