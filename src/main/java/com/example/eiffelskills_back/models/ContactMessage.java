package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "contactmessage")
public class ContactMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "mail")
    private String mail;
    @Column(name = "message")
    private String message;

    public ContactMessage() {}

    public ContactMessage(Date createdAt, String name, String surname, String mail, String message) {
        this.createdAt = createdAt;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.message = message;
    }
}
