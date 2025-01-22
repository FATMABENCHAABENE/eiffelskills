package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.ContactMessageDAO;
import com.example.eiffelskills_back.models.ContactMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactMessageService {
    private final ContactMessageDAO contactMessageDAO;

    @Transactional
    public void addContactMessage(ContactMessage contactMessage) {
        contactMessageDAO.save(contactMessage);
    }

    @Transactional
    public List<ContactMessage> getAllContactMessages() {
        return contactMessageDAO.findAll();
    }

    @Transactional
    public ContactMessage getContactMessageById(Long id) {
        return contactMessageDAO.findById(id).orElse(null);
    }

    @Transactional
    public void deleteContactMessageById(Long id) {
        contactMessageDAO.deleteById(id);
    }
}
