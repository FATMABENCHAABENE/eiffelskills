package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.AutoEvaluations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface AutoEvaluationDAO
 */
@Repository
public interface AutoEvaluationDAO extends JpaRepository<AutoEvaluations, Long> {
    /**
     * Method updateAutoEvaluationById
     * @param id Long ID of the entry to update
     * @param idSkill Long New idSkill for the entry
     * @param idStudent Long New idStudent for the entry
     * @param eval String New eval for the entry
     * @param quizzEval String New quizzEval for the entry
     * Update attributes of the entry in function of the ID
     */
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE autoevaluations SET id_skill=:idSkill, id_student=:idStudent, eval=:eval, quizz_eval=:quizzEval WHERE id=:id")
    public void updateAutoEvaluationById(Long id, Long idSkill, Long idStudent, String eval, String quizzEval);

    /**
     * Method updateAutoEvalBySkillAndStudent
     * @param eval String New eval for the entry
     * @param idSkill Long ID of the skill we search the entry
     * @param idStudent Long ID of the student we search the entry
     * Update eval attribute of the entry in function of the given ID
     */
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE autoevaluations SET eval=:eval WHERE id_skill=:idSkill and id_student=:idStudent")
    public void updateAutoEvalBySkillAndStudent(String eval, Long idSkill, Long idStudent);

    /**
     * Method updateQuizzEvalBySkillAndStudent
     * @param quizzEval String New eval for the entry
     * @param idSkill Long ID of the skill we search the entry
     * @param idStudent Long ID of the student we search the entry
     * Update quizzEval attribute of the entry in function of the given ID
     */
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE autoevaluations SET quizz_eval=:quizzEval WHERE id_skill=:idSkill and id_student=:idStudent")
    public void updateQuizzEvalBySkillAndStudent(String quizzEval, Long idSkill, Long idStudent);

    /*
    @Query(nativeQuery = true, value = "SELECT * FROM autoevaluations WHERE id_skill=:idSkill and id_student=:idStudent")
    public Optional<AutoEvaluations> findBySkillAndStudent(Long idSkill, Long idStudent);
    */
}
