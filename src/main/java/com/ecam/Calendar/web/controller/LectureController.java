package com.ecam.Calendar.web.controller;
import com.ecam.Calendar.db.dbRoom;
import com.ecam.Calendar.model.Lecture;
import com.ecam.Calendar.model.Room;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LectureController {

    @PostMapping("/Lecture/Create")
    public String lectureCreate(@RequestParam(value = "code") String code, @RequestParam(value = "day") String day,
                                 @RequestParam(value = "teachers") ArrayList<String> teachers, @RequestParam(value = "room") String room,
                                 @RequestParam(value = "start") String start, @RequestParam(value = "end") String end,
                                 @RequestParam(value = "sessionNumber") int sessionNumber) {
        Lecture lecture = new Lecture(code, day ,teachers, room, Time.valueOf(start), Time.valueOf(end), sessionNumber);

        if (lecture.create()) {
            return "Lecture "+code+" created";
        }
        else{
            List<Room> rooms = dbRoom.getRecommondations(code,day.toString(),start.toString(),end.toString());
            StringBuilder str = new StringBuilder();
            int indexRecommendation = 0;
            for (Room roomElement:rooms){
                if (indexRecommendation <= 5){
                    str.append(roomElement.roomToString());
                    indexRecommendation += 1;
                }
            }
            return "This local doesn't seem convenient, here are a few recommendation : " + str;
        }
    }

    @GetMapping("/Lecture/Read")
    public List<Lecture> lectureRead(@RequestParam(value = "code") String code){
        return Lecture.read(code);
    }

    @DeleteMapping("/Lecture/Delete")
    public String lectureDelete(@RequestParam(value = "code") String code, @RequestParam(value = "sessionNumber", defaultValue = "-43") int sessionNumber){
        if(sessionNumber == -43){
            if (Lecture.deleteLecture(code)) {
                return "deleted successful";
            }
        }
        else {
            if (Lecture.deleteSession(code, sessionNumber)) {
                return "deleted successful";
            }
        }
        return "error";
    }
}
