package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Interface ModuleDAO
 */
public interface ModuleDAO extends JpaRepository<Modules, Long> {
    /**
     * Method updateModuleById
     * @param id Long ID of the entry to update
     * @param description String New description for the entry
     * @param major String New major for the entry
     * Update entry in function of the given ID with given description and major
     */
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE modules SET description=:description, major=:major WHERE id=:id")
    public void updateModuleById(Long id, String description, String major);
}
