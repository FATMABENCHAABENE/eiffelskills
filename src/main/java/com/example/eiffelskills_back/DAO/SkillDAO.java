package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SkillDAO extends JpaRepository<Skills, Long> {
    @Query(nativeQuery = true, value = "UPDATE skills SET description=:description, id_module=:idModule WHERE id=:id")
    public void updateById(Long id, String description, Long idModule);
}
