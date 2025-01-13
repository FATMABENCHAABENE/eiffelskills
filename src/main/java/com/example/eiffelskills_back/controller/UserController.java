package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.User;
import com.example.eiffelskills_back.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    /*@GetMapping("/test")
    //@PreAuthorize("hasRole('admin')")
    public String test(@CookieValue(value = "token") String token, @CookieValue(value = "id") String id) {
        if (token.toString().equals("$2a$12$jjgvt8LvAg2P0aC9b.wPlevqNh6KPoT2EBfPoQI5XuKzTX38ufz7i")) {

            return "Test user API. Your id is " + id;
        }
            return null;
    }*/

    @PostMapping("/login")
    public Long login(@RequestBody User user, HttpServletResponse response) {
        Long id = userService.checkUser(user);
        if (id != null) {
            response.addCookie(new Cookie("token", user.getRole()));
            response.addCookie(new Cookie("id", user.getId().toString()));
            return id;
        }
        return null;
    }

    @PostMapping("/add")
    public void add(@CookieValue(value = "token") String token, @CookieValue(value = "id") String id, @RequestBody User user) {
        if (token.toString().equals("d033e22ae348aeb5660fc2140aec35850c4da997") || id.toString().equals("1")) {
            userService.addUser(user);
        }
    }

    @PostMapping("/{uid}")
    public void updateById(@CookieValue(value = "token") String token, @CookieValue(value = "id") String id, @RequestBody User user, @PathVariable Long uid) {
        if (token.toString().equals("d033e22ae348aeb5660fc2140aec35850c4da997") || id.toString().equals("1")) {

        }
    }

    /*@GetMapping("/setcookies")
    public String setCookies(HttpServletResponse response) {
        try {
            response.addCookie(new Cookie("token", "$2a$12$jjgvt8LvAg2P0aC9b.wPlevqNh6KPoT2EBfPoQI5XuKzTX38ufz7i"));
            response.addCookie(new Cookie("id", "1"));
            return "Set cookies";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return e.getMessage();
        }
    }*/
}
