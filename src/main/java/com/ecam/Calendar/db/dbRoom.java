package com.ecam.Calendar.db;

import com.ecam.Calendar.DBConnect;
import com.ecam.Calendar.model.Room;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
    public static List<Room> getRecommondations(String code,String day,String start, String end){
        //check for the rooms that are big enough and available
        List<Room> rooms= new ArrayList<>();
        try{
            DBConnect db= new DBConnect();
            ResultSet rs;
            rs =  db.GetSelect("select code_room, capacity, type from Rooms " +
                    "where capacity > (select count(*) from Link_Users_UE where UE='"+code+"') and " +
                    "(select Check_Availability(code_room,'"+day+"','"+start+"','"+end+"'))=1;");
            while (rs.next()){
                String code_room = rs.getString("code_room");
                String type = rs.getString("type");
                int capacity = rs.getInt("capacity");
                rooms.add(new Room(code_room,type,capacity));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return rooms;
    }
}

