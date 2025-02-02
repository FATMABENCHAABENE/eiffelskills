package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.ContactMessage;
import com.example.eiffelskills_back.services.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class ContactMessageController
 * Plateform users can send message through this controller and admin can use it to check and delete them
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("contactmessage")
public class ContactMessageController {
    private final ContactMessageService contactMessageService;

    /**
     * Method getContactMessage
     * @return All ContactMessage entries
     */
    @GetMapping("")
    public List<ContactMessage> getContactMessages() {
        return contactMessageService.getAllContactMessages();
    }

    /**
     * Method addContactMessag
     * @param contactMessage ContactMessage The ContactMessage entry to add
     * Add the ContactMessage object in the request
     */
    @PostMapping("")
    public void addContactMessage(@RequestBody ContactMessage contactMessage) {
        contactMessageService.addContactMessage(contactMessage);
    }

    /**
     * Method getContactMessageById
     * @param id Long ContactMessage ID to search
     * @return The ContactMessage entry with the given ID
     */
    @GetMapping("/{id}")
    public ContactMessage getContactMessageById(@PathVariable Long id) {
        return contactMessageService.getContactMessageById(id);
    }

    /**
     * Method deleteContactMessageById
     * @param id Long ID of the entry to delete
     * Delete the entry with the given ID
     */
    @DeleteMapping("/{id}")
    public void deleteContactMessageById(@PathVariable Long id) {
        contactMessageService.deleteContactMessageById(id);
    }
}
