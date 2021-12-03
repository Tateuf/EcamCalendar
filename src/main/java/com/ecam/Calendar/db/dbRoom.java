package com.ecam.Calendar.db;

import com.ecam.Calendar.DBConnect;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;

public class dbRoom {
    public static boolean checkCapacity(String room,String code) {
        //compare number of student and the capacity of a room
        ResultSet rs;
        Boolean isBigEnough = false;
        try{
            DBConnect db = new DBConnect();
            rs = db.GetSelect("select Check_Capacity('"+code+"','"+room+"');");
            rs.next();
            if (rs.getInt(1)==1) {
                isBigEnough=true;
            }
            else{
                isBigEnough=false;System.out.println('0');
            }

            db.Close_connection();
        }catch (Exception e){
            System.out.println('2');
            System.out.println(e.getMessage());
        }
        return isBigEnough;
    }

    public static boolean checkAvailability(String room, String day, String start, String end) {
        //check is a room is available for this day and this hour.
        ResultSet rs;
        boolean isAvailable=false;
        try{
            DBConnect db = new DBConnect();
            rs=db.GetSelect("select Check_Availability('"+room+"','"+day+"','"
                    +start+"','"+end+"');");
            rs.next();
            if (rs.getInt(1)==1){
                isAvailable = true;
            }else{
                isAvailable=false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return isAvailable;
    }
}

