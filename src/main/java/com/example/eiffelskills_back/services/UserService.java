package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.UserDao;
import com.example.eiffelskills_back.models.Encoder;
import com.example.eiffelskills_back.models.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    private Encoder encoder = new Encoder();

    public void displayAllUsers() {
        userDao.findAll().forEach(user -> System.out.println(user));
    }

    @Transactional
    public User checkUser(User user) {
        //System.out.println(encoder.encrypt(user.getPassword()));
        User users = userDao.findByEmailAndPassword(user.getMail(), encoder.encrypt(user.getPassword()), user.getRole());
        //System.out.println("Found User ###"+users.toString());
        if (users!=null) {
            return users;
        } else {
            return null;
        }
    }

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

    @Transactional
    public void addUser(User user) {
        user.setPassword(encoder.encrypt(user.getPassword()));
        userDao.save(user);
    }

    @Transactional
    public void updateUser(User user, Long id) {
        userDao.updateUser(user.getName(), user.getSurname(), user.getMail(), user.getPassword(), id);
    }

    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
}
