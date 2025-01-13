package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE mail=?1 and password=?2 and role=?3")
    List<User> findByEmailAndPassword(String mail, String password, String role);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE mail=?1")
    User findByMail(String mail);
}
