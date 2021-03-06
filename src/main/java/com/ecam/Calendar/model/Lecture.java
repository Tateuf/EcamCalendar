package com.ecam.Calendar.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.ecam.Calendar.db.dbLecture;


public class Lecture {
    private final String code;
    private LocalDate day;
    private ArrayList<String> teachers;
    private String room;
    private Time start;
    private Time end;
    private final int sessionNumber;

    public Lecture(String code,String day ,ArrayList<String> teachers, String room, Time start, Time end, int sessionNumber) {

        this.code = code;
        this.day = LocalDate.parse(day);
        this.teachers = teachers;
        this.room = room;
        this.start = start;
        this.end = end;
        this.sessionNumber = sessionNumber;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public ArrayList<String> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<String> teachers) {
        this.teachers = teachers;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }


    public String getCode() {
        return code;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "code='" + code + '\'' +
                ", day='" + day + '\'' +
                ", teachers=" + teachers +
                ", room='" + room + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", sessionNumber=" + sessionNumber +
                '}';
    }

    public boolean create() {
        return dbLecture.create(this.day,this.code,this.teachers,this.room,this.start,this.end,this.sessionNumber);
    }

    public static List<Lecture> read(String code) {
        return dbLecture.read(code);
    }

    public static boolean deleteLecture(String code) {
        return dbLecture.deleteLecture(code);
    }

    public static boolean deleteSession(String code,int sessionNumber) {
        return dbLecture.deleteSession(code,sessionNumber);
    }
}
