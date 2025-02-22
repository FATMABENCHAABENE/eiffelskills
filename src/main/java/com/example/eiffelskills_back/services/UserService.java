package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.UserDao;
import com.example.eiffelskills_back.models.Encoder;
import com.example.eiffelskills_back.models.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Class UserService
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    private Encoder encoder = new Encoder();

    /**
     * Method checkUser
     * @param user User Object we want to check if exists in the database
     * @return A user only if exists in the database
     */
    @Transactional
    public User checkUser(User user) {
        List<User> users = userDao.findAll();
        User foundUser = null;
        for (User u : users) {
            if (u.getMail().equals(user.getMail()) && u.getPassword().equals(user.getPassword()) && u.getRole().equals(user.getRole())) {
                foundUser = u;
                break;
            }
        }
        if (foundUser!=null) {
            return foundUser;
        } else {
            return null;
        }
    }

    /**
     * Method getStudentByMajor
     * @param major String The major we search all entries
     * @return All User entry in function of the given Major
     */
    @Transactional
    public List<User> getStudentByMajor(String major) {
        List<User> all = userDao.findAll();
        List<User> students = new ArrayList<>();
        for (User user : all) {
            if (user.getRole().contains(major) && user.getRole().contains("student")) {
                students.add(user);
            }
        }
        students.sort(Comparator.comparing(User::getName));
        return students;
    }

    /**
     * Method getAllStudents
     * @return All User entries
     */
    @Transactional
    public List<User> getAllStudents() {
        return userDao.findAll();
    }

    /**
     * Method addUser
     * @param user User Object to add in entries
     * Add the given object in user entries
     */
    @Transactional
    public void addUser(User user) {
        user.setPassword(encoder.encrypt(user.getPassword()));
        userDao.save(user);
    }

    /**
     * Method updateUser
     * @param user User Object with attributes to change in entries
     * @param id Long ID of the entry to change
     * Update User entry in function of the given ID with attributes of the given object
     */
    @Transactional
    public void updateUser(User user, Long id) {
        userDao.updateUser(user.getName(), user.getSurname(), user.getMail(), user.getPassword(), id);
    }

    /**
     * Method deleteUser
     * @param id Long ID of the entry to delete
     * Delete the User entry in function of the given ID
     */
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
}
