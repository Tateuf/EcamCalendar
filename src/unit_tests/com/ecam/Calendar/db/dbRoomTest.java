package com.ecam.Calendar.db;
import com.ecam.Calendar.DBConnect;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;


import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class dbRoomTest {
    @Test
    void checkCapacity(){
        assertEquals(true,dbRoom.checkCapacity("1D01","GA4T-T1"));
    }
    @Test
    void checkAvailability(){
        String room = "2F10";
        String day = "2021-12-21";
        String start ="12:45:00";
        String end = "17:15:00" ;
        assertEquals(false,dbRoom.checkAvailability(room,day,start,end));
        start = "10:15:00";
        end = "11:45:00";
        assertEquals(true,dbRoom.checkAvailability(room,day,start,end));
    }
}
