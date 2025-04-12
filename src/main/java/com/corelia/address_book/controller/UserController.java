package com.corelia.address_book.controller;

import com.corelia.address_book.dto.ContactDto;
import com.corelia.address_book.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add_contact")
    public ResponseEntity < ContactDto > addContact(@RequestBody @Valid ContactDto contactDto) {
        ContactDto createdContact = userService.addContact(contactDto);
        System.out.println("Contact created: " + createdContact);
        return ResponseEntity.ok(createdContact);
    }
    @GetMapping("/contacts")
    public ResponseEntity < List < ContactDto >> getAllContacts() {
        List < ContactDto > contacts = userService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("find_contact/{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable Long id) {
        ContactDto contactDto = userService.getContactById(id);
        return ResponseEntity.ok(contactDto);
    }

    @DeleteMapping("delete_contact/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        userService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}