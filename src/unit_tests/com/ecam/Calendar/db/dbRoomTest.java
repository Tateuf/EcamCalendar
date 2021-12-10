package com.ecam.Calendar.db;
import com.ecam.Calendar.DBConnect;
import com.ecam.Calendar.model.Room;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;


import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class dbRoomTest {
    @Test
    void checkCapacity(){
        assertEquals(false,dbRoom.checkCapacity("1D01","GA4T-T1"));
    }
    @Test
    void checkAvailability(){
        String room = "1D02";
        String day = "2022-12-11";
        String start ="10:15:00";
        String end = "11:45:00" ;

        assertEquals(false,dbRoom.checkAvailability(room,day,start,end));
        start = "12:45:00";
        end = "14:15:00";
        assertEquals(true,dbRoom.checkAvailability(room,day,start,end));
    }
    @Test
    void getRecommondations(){
        List<Room> rooms =  dbRoom.getRecommondations("4mage40","2022-12-12","12:45:00","14:15:00");
        assertEquals("2F20",rooms.get(0).getRoom());
        assertEquals("2F28",rooms.get(1).getRoom());

    }
}
