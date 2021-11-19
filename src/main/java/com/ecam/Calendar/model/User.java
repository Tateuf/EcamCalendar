package com.ecam.Calendar.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String firstname;
    private final String code;
    private final String role;

    public User(String name, String firstname, String code, String role) {
        this.name = name;
        this.firstname = firstname;
        this.code = code;
        this.role = role;
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

    public String getCode() {
        return code;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", code='" + code + '\'' +
                ", role='" + role + '\'' +
                '}';
    }


    public static List<User> read(String code) {
        //TODO link to database
        //Database.readLecture()
        return new ArrayList<User>();
    }
}
