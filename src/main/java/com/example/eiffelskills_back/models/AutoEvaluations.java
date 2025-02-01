package com.example.eiffelskills_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Class AutoEvaluations
 */
@Entity
@Getter
@Setter
@ToString
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
    @Column(name = "quizz_eval", nullable = false)
    private String quizzEval;

    /**
     * Empty Constructor
     */
    public AutoEvaluations() {}

    /**
     * Constructor
     * @param idSkill Long
     * @param idStudent Long
     * @param eval String
     * @param quizzEval String
     */
    public AutoEvaluations(Long idSkill, Long idStudent, String eval, String quizzEval) {
        this.idSkill = idSkill;
        this.idStudent = idStudent;
        this.eval = eval;
        this.quizzEval = quizzEval;
    }

    /**
     * Method toString
     * @return String
     */
    @Override
    public String toString() {
        return "["+idSkill+", "+idStudent+", "+eval+", "+quizzEval+"]";
    }
}
