package com.ecam.Calendar.db;

import com.ecam.Calendar.DBConnect;
import com.ecam.Calendar.model.Lecture;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class dbUser {

    public static boolean subscribe(String noma, String UEcode) {
        try{
            DBConnect db = new DBConnect();
            db.Insert("Insert into Link_Users_UE(User, UE) values('"+noma+"','"+UEcode+ "');");
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
        ResultSet rs;
        try{
            DBConnect db = new DBConnect();
            System.out.println(noma.length());
            if(noma.length() == 5){
                rs = db.GetSelect("Select * from Lecture where code_lecture in  " +
                        "(Select FK_lecture from UE where code_UE in (Select UE from Link_Users_UE where User = '"+ noma + "' ));");
            }
            else {
                rs = db.GetSelect("Select * from Lecture where code_lecture in" +
                        "(Select Pk_lecture from Lectures where teachers like '"+noma+"');");
            }
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
}
