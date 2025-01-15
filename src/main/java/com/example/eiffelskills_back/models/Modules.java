package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

    public Modules() {}

    public Modules(String description, String major, Long idTeacher) {
        this.description = description;
        this.major = major;
        this.idTeacher = idTeacher;
    }
}
