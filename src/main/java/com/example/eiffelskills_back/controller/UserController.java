package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.User;
import com.example.eiffelskills_back.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public boolean login(@RequestBody User user) {
        return userService.checkUser(user);
    }
}
