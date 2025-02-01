package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Class Modules
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "modules")
public class Modules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "major", nullable = false)
    private String major;
    @Column(name = "id_teacher", nullable = false)
    private Long idTeacher;

    /**
     * Empty Constructor
     */
    public Modules() {}

    /**
     * Constructor
     * @param description String
     * @param major String
     * @param idTeacher Long
     */
    public Modules(String description, String major, Long idTeacher) {
        this.description = description;
        this.major = major;
        this.idTeacher = idTeacher;
    }
}
