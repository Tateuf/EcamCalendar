package com.ecam.Calendar.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Lecture {
    private final String topic;
    private final String code;
    private ArrayList<String> teachers;
    private String room;
    private Time start;
    private Time end;
    private final int sessionNumber;

    public Lecture(String topic, String code, ArrayList<String> teachers, String room, Time start, Time end, int sessionNumber) {
        this.topic = topic;
        this.code = code;
        this.teachers = teachers;
        this.room = room;
        this.start = start;
        this.end = end;
        this.sessionNumber = sessionNumber;
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

    public String getTopic() {
        return topic;
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
                "topic='" + topic + '\'' +
                ", code='" + code + '\'' +
                ", teachers=" + teachers +
                ", room='" + room + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", sessionNumber=" + sessionNumber +
                '}';
    }


    public void create() {
        //TODO link to database
        //Database.CreateLecture()
    }


    public static List<Lecture> read(String code) {
        //TODO link to database
        //Database.readLecture()
        return new ArrayList<Lecture>();
    }

    public static void deleteLecture(String code) {
        //TODO link to database
        //Database.deleteLectures()
    }

    public static void deleteSession(String code,int sessionNumber) {
        //TODO link to database
        //Database.deleteLecture()
    }
}
