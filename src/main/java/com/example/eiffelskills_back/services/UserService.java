package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.UserDao;
import com.example.eiffelskills_back.models.Encoder;
import com.example.eiffelskills_back.models.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    private Encoder encoder = new Encoder();

    @Transactional
    public Long checkUser(User user) {
        Iterable<User> users = userDao.findByEmailAndPassword(user.getMail(), encoder.encrypt(user.getPassword()), user.getRole());
        if (users.iterator().hasNext()) {
            return users.iterator().next().getId();
        } else {
            return null;
        }
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
/*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByMail(username);
        SimpleGrantedAuthority authoritie = new SimpleGrantedAuthority(user.getRole());
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                Collections.singleton(authoritie)
        );
    }*/
}
