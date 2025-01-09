package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.UserDao;
import com.example.eiffelskills_back.models.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    @Transactional
    public boolean checkUser(User user) {
        Iterable<User> users = userDao.findByEmailAndPassword(user.getMail(), user.getPassword(), user.getRole());
        if (users.iterator().hasNext()) {
            return true;
        } else {
            return false;
        }
    }
}
