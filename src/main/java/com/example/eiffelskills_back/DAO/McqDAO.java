package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Mcq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Interface McqDAO
 */
public interface McqDAO extends JpaRepository<Mcq, Long> {
    /**
     * Method deleteByIdModule
     * @param idModule Long ID of the module we want to delete entry
     * Delete Mcq entry in function of the idModule
     */
    @Modifying
    @Query(nativeQuery = true, value="DELETE FROM mcq WHERE id_module=:idModule")
    public void deleteByIdModule(Long idModule);
}
