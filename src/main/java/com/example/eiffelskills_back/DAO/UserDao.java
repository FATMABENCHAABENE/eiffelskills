package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE mail=?1 and password=?2")
    User findByEmailAndPassword(String mail, String password, String role);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE mail=?1")
    User findByMail(String mail);

    @Query(nativeQuery = true, value = "UPDATE users SET name=:name, surname=:surname, mail=:mail, password=:password WHERE id=:id")
    void updateUser(@Param("name") String name, @Param("surname") String surname, @Param("mail") String mail, @Param("password") String password, @Param("id") Long id);
}
