package com.ecam.Calendar.web.controller;
import com.ecam.Calendar.model.Lecture;
import com.ecam.Calendar.model.Room;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {

    @GetMapping("/Room/Read")
    public List<String> roomRead(@RequestParam(value = "room") ArrayList<String> room){
        return Room.grabRoomFromDB(room);
    }
}
