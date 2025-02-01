package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerDAO extends JpaRepository<Answers,Long> {
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE awnsers SET is_good=true WHERE id=:id")
    void updateGoodAwnser(Long id);
}
