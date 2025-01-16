package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Getter
@Setter
@Table(name = "mcq")
public class Mcq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "decription", nullable = false)
    private String description;
    @Column(name = "id_module")
    private Long idModule;

    public Mcq() {}
    public Mcq(String description, Long id_module) {
        this.description = description;
        this.idModule = id_module;
    }
}
