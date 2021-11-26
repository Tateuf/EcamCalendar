package com.ecam.Calendar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectTest {

    @Test
    void Connect_to_DB() {
        DBConnect db = new DBConnect();
        assertEquals(0, db.Connect_to_DB());
    }
}