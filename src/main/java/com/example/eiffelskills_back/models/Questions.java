package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @Class Questions
 */
@Entity
@Getter
@Setter
@Table(name = "questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "id_mcq", nullable = false)
    private Long idMcq;
    @Column(name = "id_skill", nullable = false)
    private Long idSkill;

    /**
     * Empty Constructor
     */
    public Questions() {}

    /**
     * Constructor
     * @param description String
     * @param idMcq Long
     * @param idSkill Long
     */
    public Questions(String description, Long idMcq, Long idSkill) {
        this.description = description;
        this.idMcq = idMcq;
        this.idSkill = idSkill;
    }
}
