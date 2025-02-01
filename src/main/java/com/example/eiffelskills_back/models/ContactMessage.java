package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Class ContactMessage
 */
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
    private LocalDate createdAt = LocalDate.now();
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "mail")
    private String mail;
    @Column(name = "message")
    private String message;

    /**
     * Empty Constructor
     */
    public ContactMessage() {}

    /**
     * Constructor
     * @param name String
     * @param surname String
     * @param mail String
     * @param message String
     */
    public ContactMessage(String name, String surname, String mail, String message) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.message = message;
    }
}
