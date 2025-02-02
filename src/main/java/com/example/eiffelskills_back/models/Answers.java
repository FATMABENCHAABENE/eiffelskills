package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Answer
 */
@Entity
@Getter
@Setter
@Table(name = "awnsers")
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "is_good")
    private boolean isGood;
    @Column(name = "id_question")
    private Long idQuestion;

    /**
     * Empty constructor
     */
    public Answers() {}

    /**
     * Constructor
     * @param description String
     * @param isGood boolean
     * @param idQuestion Long
     */
    public Answers(String description, boolean isGood, Long idQuestion) {
        this.description = description;
        this.isGood = isGood;
        this.idQuestion = idQuestion;
    }

    /**
     * Method isGood
     * @return True only if the answer is correct
     */
    public boolean isGood() {
        return isGood;
    }
}
