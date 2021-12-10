package com.ecam.Calendar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectTest {

    @Test
    void Connect_to_DB() {
        DBConnect db = new DBConnect();
        assertEquals(0, db.Connect_to_DB());
    }


    @Test
    void select() {
        DBConnect db = new DBConnect();
        assertEquals(0,db.Select("SELECT * FROM Logiciel.Users;"));

    }

    @Test
    void insert() {
        DBConnect db = new DBConnect();
        //if that one throws error try changing the code_user because
        //its a primary key or just delete that row in the table with workbench
        if(db.Insert("INSERT INTO Logiciel.Users(code_user,lastName,firstName,role) VALUES ('TEST','Test','Testy','teacher');") == 1){
            assertEquals(0,db.Insert("DELETE From Logiciel.Users where code_user = 'TEST' ;"));
            assertEquals(0,db.Insert("INSERT INTO Logiciel.Users(code_user,lastName,firstName,role) VALUES ('TEST','Test','Testy','teacher');"));
        }
    }

}