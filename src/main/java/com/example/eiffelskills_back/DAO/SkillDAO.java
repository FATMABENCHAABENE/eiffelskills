package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Interface SkillDAO
 */
public interface SkillDAO extends JpaRepository<Skills, Long> {
    /**
     * Method updateById
     * @param id Long ID of the entry to update
     * @param description String New description for the entry
     * @param idModule String New idModule for the entry
     * Update entry in function of the given ID with given description and idModule
     */
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE skills SET description=:description, id_module=:idModule WHERE id=:id")
    public void updateById(Long id, String description, Long idModule);
}
