package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.Resources;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourcesDAO extends JpaRepository<Resources, Long> {
}
