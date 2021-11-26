package com.ecam.Calendar.web.controller;
import com.ecam.Calendar.model.Lecture;
import com.ecam.Calendar.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @GetMapping("/User/Read")
    public List<User> UserRead(@RequestParam(value = "noma") String noma) {
        return User.read(noma);
    }

}
