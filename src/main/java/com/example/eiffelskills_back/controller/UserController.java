package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.User;
import com.example.eiffelskills_back.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @GetMapping("/test")
    //@PreAuthorize("hasRole('admin')")
    public String test(@CookieValue(value = "token") String token, @CookieValue(value = "id") String id) {
        if (token == "$2a$12$jjgvt8LvAg2P0aC9b.wPlevqNh6KPoT2EBfPoQI5XuKzTX38ufz7i" && id != null) {
            return "Test user API";
        }
            return null;
    }

    @PostMapping("/login")
    public Long login(@RequestBody User user) {
        return userService.checkUser(user);
    }
}
