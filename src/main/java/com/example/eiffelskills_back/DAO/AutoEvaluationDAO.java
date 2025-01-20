package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.AutoEvaluations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AutoEvaluationDAO extends JpaRepository<AutoEvaluations, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE autoevaluations SET id_skill=:idSkill, id_student=:idStudent, eval=:eval WHERE id=:id")
    public void updateAutoEvaluationById(Long id, Long idSkill, Long idStudent, String eval);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE autoevaluations SET eval=:eval WHERE id_skill=:idSkill and id_student=:idStudent")
    public void updateAutoEvaluationBySkillAndStudent(String eval, Long idSkill, Long idStudent);

    @Query(nativeQuery = true, value = "SELECT * FROM autoevaluations WHERE id_skill=:idSkill and id_student=:idStudent")
    public Optional<AutoEvaluations> findBySkillAndStudent(Long idSkill, Long idStudent);
}
