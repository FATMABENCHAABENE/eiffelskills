package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.ContactMessage;
import com.example.eiffelskills_back.services.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("contactmessage")
public class ContactMessageController {
    private final ContactMessageService contactMessageService;

    @GetMapping("")
    public List<ContactMessage> getContactMessages() {
        return contactMessageService.getAllContactMessages();
    }

    @PostMapping("")
    public void addContactMessage(@RequestBody ContactMessage contactMessage) {
        contactMessageService.addContactMessage(contactMessage);
    }

    @GetMapping("/{id}")
    public ContactMessage getContactMessageById(@PathVariable Long id) {
        return contactMessageService.getContactMessageById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContactMessageById(@PathVariable Long id) {
        contactMessageService.deleteContactMessageById(id);
    }
}
