package com.corelia.address_book.service;


import com.corelia.address_book.dto.ContactDto;
import com.corelia.address_book.model.Contact;
import com.corelia.address_book.model.User;
import com.corelia.address_book.repository.ContactRepository;
import com.corelia.address_book.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // This class is currently empty, but it can be used to implement user-related business logic
    // such as user registration, authentication, and profile management.

    private final UserRepository userRepository;
    private final ContactRepository contactRepository;


    public UserService(UserRepository userRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }



    public ContactDto addContact(ContactDto contactDto) {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        // Fetch the user from the database
        User user = userRepository.findByEmail(currentUser.getEmail())
                .orElseThrow(() -> new RuntimeException("Authenticated user not found"));

        // Create a new Contact and associate it with the user
        Contact contact = new Contact();
        contact.setFirstName(contactDto.firstName());
        contact.setLastName(contactDto.lastName());
        contact.setPhoneNumber(contactDto.phoneNumber());
        contact.setEmail(contactDto.email());
        contact.setBirthdate(contactDto.birthdate());
        contact.setUser(user);

        // Save the contact
        Contact savedContact = contactRepository.save(contact);
        System.out.println("Saved contact: " + savedContact);

        // Return the saved contact as a DTO
        return new ContactDto(
                savedContact.getFirstName(),
                savedContact.getLastName(),
                savedContact.getPhoneNumber(),
                savedContact.getEmail(),
                savedContact.getBirthdate()
        );
    }

    public List<ContactDto> getAllContacts() {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        User user = userRepository.findByEmail(currentUser.getEmail())
                .orElseThrow(() -> new RuntimeException("Authenticated user not found"));
        System.out.println("Authenticated user: " + user.getEmail());
        // Fetch all contacts associated with the user
        List<Contact> contacts = contactRepository.findByUserEmail(currentUser.getEmail());

        // Convert to DTOs
        return contacts.stream()
                .map(contact -> new ContactDto(
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getPhoneNumber(),
                        contact.getEmail(),
                        contact.getBirthdate()
                ))
                .toList();
    }

    public ContactDto getContactById(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        // Fetch the user from the database
        User user = userRepository.findByEmail(currentUser.getEmail())
                .orElseThrow(() -> new RuntimeException("Authenticated user not found"));

        // Fetch the contact by ID and ensure it belongs to the authenticated user
        Contact contact = contactRepository.findByIdAndUserEmail(id, currentUser.getEmail())
                .orElseThrow(() -> new RuntimeException("Contact not found or does not belong to the authenticated user"));

        // Convert to DTO
        return new ContactDto(
                contact.getFirstName(),
                contact.getLastName(),
                contact.getPhoneNumber(),
                contact.getEmail(),
                contact.getBirthdate()
        );
    }

    public void deleteContact(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        // Fetch the user from the database
        User user = userRepository.findByEmail(currentUser.getEmail())
                .orElseThrow(() -> new RuntimeException("Authenticated user not found"));

        // Fetch the contact by ID and ensure it belongs to the authenticated user
        Contact contact = contactRepository.findByIdAndUserEmail(id, currentUser.getEmail())
                .orElseThrow(() -> new RuntimeException("Contact not found or does not belong to the authenticated user"));

        // Delete the contact
        contactRepository.delete(contact);
    }


}
