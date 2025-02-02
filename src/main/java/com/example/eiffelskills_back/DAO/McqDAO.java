package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Mcq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Interface McqDAO
 */
public interface McqDAO extends JpaRepository<Mcq, Long> {
    /*
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE mcq SET description=:description where id_module=:idModule")
    public Mcq updateByIdModule(String description, Long idModule);
    */

    /**
     * Method deleteByIdModule
     * @param idModule Long ID of the module we want to delete entry
     * Delete Mcq entry in function of the idModule
     */
    @Modifying
    @Query(nativeQuery = true, value="DELETE FROM mcq WHERE id_module=:idModule")
    public void deleteByIdModule(Long idModule);
}
