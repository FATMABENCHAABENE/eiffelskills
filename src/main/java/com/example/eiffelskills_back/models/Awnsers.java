package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "awnsers")
public class Awnsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "is_good")
    private boolean isGood;
    @Column(name = "id_question")
    private Long idQuestion;

    public Awnsers() {}

    public Awnsers(String description, boolean isGood, Long idQuestion) {
        this.description = description;
        this.isGood = isGood;
        this.idQuestion = idQuestion;
    }

    public boolean isGood() {
        return isGood;
    }
}
