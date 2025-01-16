package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Mcq;
import org.springframework.data.jpa.repository.JpaRepository;


public interface McqDAO extends JpaRepository<Mcq, Long> {
}
