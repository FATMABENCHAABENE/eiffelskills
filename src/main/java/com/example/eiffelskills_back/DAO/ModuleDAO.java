package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Iterator;
import java.util.List;

public interface ModuleDAO extends JpaRepository<Modules, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM modules WHERE major=?1")
    public Iterator<Modules> findByMajor(String major);
}
