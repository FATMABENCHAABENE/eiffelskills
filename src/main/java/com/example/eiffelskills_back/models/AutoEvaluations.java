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
    @Column(name = "id_skill", nullable = false)
    private Long idSkill;
    @Column(name = "id_student", nullable = false)
    private Long idStudent;
    @Column(name = "eval", nullable = false)
    private String eval;

    public AutoEvaluations() {}

    public AutoEvaluations(Long idSkill, Long idStudent, String eval) {
        this.idSkill = idSkill;
        this.idStudent = idStudent;
        this.eval = eval;
    }
}
