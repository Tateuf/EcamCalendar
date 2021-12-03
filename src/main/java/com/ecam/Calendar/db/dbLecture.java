package com.ecam.Calendar.db;

import com.ecam.Calendar.model.Lecture;

import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


import com.ecam.Calendar.DBConnect;


public class dbLecture {

    public static boolean create(LocalDate day, String code,
                              ArrayList<String> teachers, String room,
                              Time start, Time end, int sessionNumber) {
        StringBuilder strTeachers = new StringBuilder();
        for (int i = 0; i < teachers.toArray().length ; i++){
            strTeachers.append(teachers.toArray()[i]);
            strTeachers.append(" ");
        }
        try{
            DBConnect db = new DBConnect();
            db.Insert("Insert into Lecture(`code_lecture`,`room`, `startTime`,`endTime`, `sessionNumber`,`teachers`, `weekDay`) " +
                    "values('" + code +"','"+room+"','"+ start +"','"+ end + "','"+ sessionNumber + "','" +strTeachers+ "','" +day+"');");
            db.Close_connection();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


    public static ArrayList<Lecture> read(String code) {
        ArrayList<Lecture> lectures = new ArrayList<>();
        ResultSet rs;
        try{
            DBConnect db = new DBConnect();
            rs = db.GetSelect("Select * from Lecture where code_lecture = '"+code+"';");
            while (rs.next()){

                String UECode = rs.getString("code_lecture");
                String topic = rs.getString("topic_lecture");
                String room = rs.getString("room");
                String day = rs.getString("weekDay");
                Time start_time = rs.getTime("startTime");
                Time end_time = rs.getTime("endTime");
                int session_number = rs.getInt("sessionNumber");
                String teachers = rs.getString("teachers");
                ArrayList<String> list_teachers = new ArrayList<String>(Arrays.asList(teachers.split("\\s")));
                lectures.add(new Lecture(UECode,day,list_teachers,room,start_time,end_time,session_number));
            }
            System.out.println(lectures);
            db.Close_connection();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return lectures;
    }


    public static boolean deleteLecture(String code) {
        try{
            DBConnect db = new DBConnect();
            db.Insert("Delete * from Lecture where code_lecture = '"+code+"';");
            db.Close_connection();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean deleteSession(String code, int sessionNumber) {
        try{
            DBConnect db = new DBConnect();
            db.Insert("Delete * from Lecture where code_lecture = '"+code+"' and sessionNumber = '"+sessionNumber+"';");
            db.Close_connection();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
