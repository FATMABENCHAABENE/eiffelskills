package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionDAO extends JpaRepository<Questions, Long> {

}
