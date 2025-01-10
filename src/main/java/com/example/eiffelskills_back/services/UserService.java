package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.UserDao;
import com.example.eiffelskills_back.models.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserDao userDao;

    @Transactional
    public Long checkUser(User user) {
        Iterable<User> users = userDao.findByEmailAndPassword(user.getMail(), user.getPassword(), user.getRole());
        if (users.iterator().hasNext()) {
            return users.iterator().next().getId();
        } else {
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByMail(username);
        GrantedAuthority authoritie = new SimpleGrantedAuthority(user.getRole());
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                (Collection<? extends GrantedAuthority>) authoritie
        );
    }
}
