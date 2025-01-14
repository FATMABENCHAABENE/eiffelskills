package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.AutoEvaluations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AutoEvaluationDAO extends JpaRepository<AutoEvaluations, Long> {
    @Query(nativeQuery = true, value = "UPDATE autoevaluation SET id_skill=:idSkill, id_student=:idStudent, eval=:eval WHERE id=:id")
    public void updateAutoEvaluationById(Long id, Long idSkill, Long idStudent, String eval);

    @Query(nativeQuery = true, value = "UPDATE autoevaluation SET eval=:eval WHERE id_skill=:idSkill and id_student=:idStudent")
    public void updateAutoEvaluationBySkillAndStudent(Long idSkill, Long idStudent, String eval);

    @Query(nativeQuery = true, value = "SELECT * FROM autoevaluation WHERE id_skill=:idSkill and id_student=:idStudent")
    public Optional<AutoEvaluations> findBySkillAndStudent(Long idSkill, Long idStudent);
}
