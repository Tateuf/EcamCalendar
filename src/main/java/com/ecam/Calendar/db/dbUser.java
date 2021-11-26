package com.ecam.Calendar.db;

import com.ecam.Calendar.DBConnect;
import com.ecam.Calendar.model.Lecture;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class dbUser {

    public static boolean subscribe(String noma, String UEcode) {
        try{
            DBConnect db = new DBConnect();
            db.Insert("Insert into Link_Users_UE( User, UE) values(" +noma+", "+UEcode+ ");");
            db.Close_connection();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static List<Lecture> getLectures(String noma) {
        List<Lecture> lectures = new ArrayList<>();
        //blabla sql
        ResultSet rs;
        try{
            DBConnect db = new DBConnect();
            // "
            //                    "(Select UE from Link_Users_UE where User = "+ noma + " ;"
            rs = db.GetSelect("Select * from Lecture where code_lecture in  " +
                    "(Select UE from Link_Users_UE where User = '"+ noma + "' );");
            while (rs.next()){
                //System.out.println(rs.getString("UE"));

                String UECode = rs.getString("code_lecture");
                String topic = rs.getString("topic");
                String room = rs.getString("room");
                String day = rs.getString("day");
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
}
