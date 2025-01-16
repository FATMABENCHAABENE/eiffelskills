package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Mcq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface McqDAO extends JpaRepository<Mcq, Long> {
    @Query(nativeQuery = true, value = "UPDATE mcq SET description=:description where id_module=:idModule")
    public Mcq updateByIdModule(String description, Long idModule);

    @Query(nativeQuery = true, value="DELETE FROM mcq WHERE id_module=:idModule")
    public void deleteByIdModule(Long idModule);
}
