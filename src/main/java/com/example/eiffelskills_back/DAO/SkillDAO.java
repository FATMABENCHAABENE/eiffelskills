package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillDAO extends JpaRepository<Skills, Long> {
}
