package com.example.eiffelskills_back.DAO;

import com.example.eiffelskills_back.models.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageDAO extends JpaRepository<ContactMessage, Long> {
}
