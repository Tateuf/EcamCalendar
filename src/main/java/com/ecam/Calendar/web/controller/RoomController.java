package com.ecam.Calendar.web.controller;

import com.ecam.Calendar.model.Room;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {


    @GetMapping("/Room/checkCapacity")
    public String checkCapacity(@RequestParam(value = "room") String room,@RequestParam(value= "code")String code){
        return String.valueOf(Room.checkCapacity(room, code));
    }

    @GetMapping("Room/Available")
    public String checkAvailability(@RequestParam(value = "room") String room,
                                     @RequestParam(value = "day") String day,
                                     @RequestParam(value = "start") String start,
                                     @RequestParam(value = "end") String end){
    return String.valueOf(Room.checkAvailability(room,day,start,end));
    }
}
