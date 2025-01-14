package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "autoevaluations")
public class AutoEvaluations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_skills", nullable = false)
    private Long id_skill;
    @Column(name = "id_student", nullable = false)
    private Long id_student;
    @Column(name = "eval", nullable = false)
    private String eval;

    public AutoEvaluations() {}

    public AutoEvaluations(Long id_skill, Long id_student, String eval) {
        this.id_skill = id_skill;
        this.id_student = id_student;
        this.eval = eval;
    }
}
