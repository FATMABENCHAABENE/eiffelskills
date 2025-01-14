package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.User;
import com.example.eiffelskills_back.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> login(@RequestBody User user, HttpServletResponse response) {
        //System.out.println("Requête reçue avec utilisateur : " + user.toString());
        //System.out.println("#### All users ####");
        //userService.displayAllUsers();
        User loggedUser = userService.checkUser(user);
        System.out.println("Found User :\n"+loggedUser);
        if (loggedUser != null) {
            System.out.println("Le user n'est pas nulle ");
            //response.addCookie(new Cookie("token", user.getRole()));
            //response.addCookie(new Cookie("id", id.toString()));
            return new ResponseEntity<User>(loggedUser, HttpStatus.OK);
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
            userService.updateUser(user, uid);
        }
    }

    @DeleteMapping("/{did}")
    public void deleteById(@CookieValue(value = "token") String token, @CookieValue(value = "id") String id, @PathVariable Long did) {
        if (token.toString().equals("d033e22ae348aeb5660fc2140aec35850c4da997") || id.toString().equals("1")) {
            userService.deleteUser(did);
        }
    }

    /*@GetMapping("/setcookie")
    public ResponseEntity<String> setCookies(HttpServletResponse response) {
        try {
            //response.addCookie(new Cookie("token", "$2a$12$jjgvt8LvAg2P0aC9b.wPlevqNh6KPoT2EBfPoQI5XuKzTX38ufz7i"));
            //response.addCookie(new Cookie("id", "1"));
            response.addHeader("token", "$2a$12$jjgvt8LvAg2P0aC9b.wPlevqNh6KPoT2EBfPoQI5XuKzTX38ufz7i");
            return new ResponseEntity<>("Set Cookies", HttpStatus.OK);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
}
