package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Class Skills
 */
@Getter
@Setter
@Entity
@ToString
@Table(name = "skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "id_module", nullable = false)
    private Long idModule;

    /**
     * Empty Constructor
     */
    public Skills() {}

    /**
     * Constructor
     * @param description String
     * @param idModule String
     */
    public Skills(String description, Long idModule) {
        this.description = description;
        this.idModule = idModule;
    }
}
