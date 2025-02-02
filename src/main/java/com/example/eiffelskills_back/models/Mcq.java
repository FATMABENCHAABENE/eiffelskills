package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

/**
 * Class Mcq
 */
@Entity
@Getter
@Setter
@Table(name = "mcq")
public class Mcq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description", nullable = false)
    private String description;
    @Getter
    @Column(name = "id_module")
    private Long idModule;

    /**
     * Empty Constructor
     */
    public Mcq() {}

    /**
     * Constructor
     * @param description String
     * @param id_module Long
     */
    public Mcq(String description, Long id_module) {
        this.description = description;
        this.idModule = id_module;
    }

    /**
     * Method toString
     * @return String
     */
    @Override
    public String toString() {
        return "MCQ :\n\t" + description + "\n\t" + idModule;
    }
}
