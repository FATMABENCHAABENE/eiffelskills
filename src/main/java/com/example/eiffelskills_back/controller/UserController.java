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
import java.util.List;

/**
 * Class UserController
 * All the user management is made with this Controller
 */
@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    /**
     * Method login
     * @param user User Platform user to check if exists
     * @param response !Not used!
     * @return A ResponseEntity(User) if the user exists
     */
   @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user, HttpServletResponse response) {
                User loggedUser = userService.checkUser(user);
        System.out.println("Found User :\n"+loggedUser);
        if (loggedUser != null) {
            System.out.println("Le user n'est pas nulle ");
            return new ResponseEntity<User>(loggedUser, HttpStatus.OK);
        }
        return null;
    }

    /**
     * Method getAllUsers
     * @return All Users entries
     */
    @GetMapping("")
    public List<User> getAllUsers() {
       return userService.getAllStudents();
    }

    /**
     * Method getStudentByMajor
     * @param major String The major we are searching all users
     * @return All Users entries with the given major
     */
    @GetMapping("/student/{major}")
    public List<User> getStudentByMajor(@PathVariable String major) {
       return userService.getStudentByMajor(major);
    }

    /**
     * Method add
     * @param user The object to add in entries
     * Add the given Users object in entries
     */
    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userService.addUser(user);
    }

    /**
     * Method updateById
     * @param user User Object with attributes to change
     * @param uid Long ID of the user to update
     * Update Users entries in function of the given ID with attributes of the given Users object
     */
    @PostMapping("/{uid}")
    public void updateById(@RequestBody User user, @PathVariable Long uid) {
        userService.updateUser(user, uid);
    }

    /**
     * Method deleteById
     * @param did Long ID of the entry to delete
     * Delete the Users entry in function of the given ID
     */
    @DeleteMapping("/{did}")
    public void deleteById(@PathVariable Long did) {
        userService.deleteUser(did);
    }
}
