package com.ecam.Calendar.model;

import java.util.ArrayList;

public class Room {
    private ArrayList<String> room;
    private String type;
    private int capacity;
    private Lecture lecture;
    //private  teacher;


    public Room(ArrayList<String> room, String type, int capacity, Lecture lecture) {
        this.room = room;
        this.type = type;
        this.capacity = capacity;
        this.lecture = lecture;
    }

    public ArrayList<String> getRoom() {
        return room;
    }

    public void setRoom(ArrayList<String> room) {
        this.room = room;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room='" + room + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                ", lecture=" + lecture +
                '}';
    }

    public static ArrayList<String> grabRoomFromDB (ArrayList<String> room) {
        //TODO link to database
        return new ArrayList<String>();
    }

    public static void grabCapacityFromDB (int capacity) {
        //TODO link to database
    }

    //lab or auditorium
    public static void grabTypeFromDB (String type) {
        //TODO link to database
    }

}
