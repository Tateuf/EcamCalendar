package com.ecam.Calendar.web.controller;
import com.ecam.Calendar.model.Lecture;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LectureController {

    @PostMapping("/Lecture/Create")
    public Lecture lectureCreate(@RequestParam(value = "topic") String topic, @RequestParam(value = "code") String code ,
                                 @RequestParam(value = "teachers") ArrayList<String> teachers, @RequestParam(value = "room") String room,
                                 @RequestParam(value = "start") String start, @RequestParam(value = "end") String end,
                                 @RequestParam(value = "sessionNumber") int sessionNumber) {
        Lecture lecture = new Lecture(topic, code, teachers, room, Time.valueOf(start), Time.valueOf(end), sessionNumber);
        lecture.create();
        return lecture;
    }

    @GetMapping("/Lecture/Read")
    public List<Lecture> lectureRead(@RequestParam(value = "code") String code){
        return Lecture.read(code);
    }

    @DeleteMapping("/Lecture/Delete")
    public String lectureDelete(@RequestParam(value = "code") String code, @RequestParam(value = "sessionNumber", defaultValue = "-43") int sessionNumber){
        if(sessionNumber == -43){
            Lecture.deleteLecture(code);
        }
        else{
            Lecture.deleteSession(code,sessionNumber);
        }
        return "deleted successful";
    }
}
