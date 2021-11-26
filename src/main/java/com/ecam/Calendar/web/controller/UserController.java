package com.ecam.Calendar.web.controller;
import com.ecam.Calendar.model.Lecture;
import com.ecam.Calendar.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @GetMapping("/User/Lectures")
    public List<Lecture> UserLectures(@RequestParam(value = "noma") String noma) {
        return User.getLectures(noma);
    }

    @PostMapping("/User/Subscribe")
    public String UserSubscribe(@RequestParam(value = "noma") String noma, @RequestParam(value = "UEcode") String UEcode){
        boolean response;
        response = User.subscribe(noma,UEcode);
        if(response) {
            return "user : " + noma + " is register to : " + UEcode;
        }
        else {
            return "error try later";
        }
    }
}
