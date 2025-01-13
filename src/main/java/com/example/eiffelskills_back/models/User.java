package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "mail", nullable = false)
    private String mail;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "role")
    private String role;

    public User(){}

    public User(String name, String surname, String mail, String password, String role) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
    }
}
