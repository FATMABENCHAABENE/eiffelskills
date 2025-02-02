package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.ContactMessageDAO;
import com.example.eiffelskills_back.models.ContactMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class ContactMessageService
 */
@Service
@RequiredArgsConstructor
public class ContactMessageService {
    private final ContactMessageDAO contactMessageDAO;

    /**
     * Method addContactMessage
     * @param contactMessage ContactMessage Object to add in entries
     * Add the given object in ContactMessage entries
     */
    @Transactional
    public void addContactMessage(ContactMessage contactMessage) {
        contactMessageDAO.save(contactMessage);
    }

    /**
     * Method getAllContactMessages
     * @return All ContactMessage entries
     */
    @Transactional
    public List<ContactMessage> getAllContactMessages() {
        return contactMessageDAO.findAll();
    }

    /**
     * Method getContactMessageById
     * @param id Long ID of the searched entry
     * @return The ContactMessage entry in function of the given ID
     */
    @Transactional
    public ContactMessage getContactMessageById(Long id) {
        return contactMessageDAO.findById(id).orElse(null);
    }

    /**
     * Method deleteContactMessageById
     * @param id Long ID of the entry to delete
     * Delete the ContactMessage entry in function of the given ID
     */
    @Transactional
    public void deleteContactMessageById(Long id) {
        contactMessageDAO.deleteById(id);
    }
}
