package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface AnswerDAO
 */
@Repository
public interface AnswerDAO extends JpaRepository<Answers,Long> {
    /**
     * Method updateGoodAwnser
     * @param id Long ID of the entry to update
     * Change the is_good attribute to true in function of the given ID
     */
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE awnsers SET is_good=true WHERE id=:id")
    void updateGoodAwnser(Long id);
}
