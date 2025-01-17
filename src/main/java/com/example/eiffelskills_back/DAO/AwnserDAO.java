package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Awnsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AwnserDAO extends JpaRepository<Awnsers,Long> {
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE awnsers SET is_good=true WHERE id=:id")
    void updateGoodAwnser(Long id);
}
