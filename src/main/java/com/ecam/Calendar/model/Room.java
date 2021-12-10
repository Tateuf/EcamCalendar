package com.ecam.Calendar.model;

import com.ecam.Calendar.db.dbRoom;


public class Room {
    private String room;
    private String type;
    private int capacity;

    public Room(String room, String type, int capacity) {
        this.room = room;
        this.type = type;
        this.capacity = capacity;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
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

    @Override
    public String toString() {
        return "Room{" +
                "room='" + room + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }
    public static boolean checkCapacity(String room, String code) {
        return dbRoom.checkCapacity(room, code);
    }

    public static boolean checkAvailability(String room, String day, String start, String end) {
        return dbRoom.checkAvailability(room,day,start,end);
    }

    public String roomToString(){
        return "[ Room = '" + room +"' capacity = '"+ capacity + "' ]";
    }

}
