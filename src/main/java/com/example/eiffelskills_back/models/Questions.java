package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "id_mcq")
    private Long idMcq;

    public Questions() {}

    public Questions(String description, Long idMcq) {
        this.description = description;
        this.idMcq = idMcq;
    }
}
