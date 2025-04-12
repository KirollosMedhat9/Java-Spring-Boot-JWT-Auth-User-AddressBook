package com.corelia.address_book.mapper;

import com.corelia.address_book.dto.ContactDto;
import com.corelia.address_book.model.Contact;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ContactDtoMapper {
    // This class is responsible for mapping between Contact and ContactDto
    // It should contain methods to convert Contact to ContactDto and vice versa

    // Example method to convert Contact to ContactDto
    public ContactDto toDto(Contact contact) {
        return new ContactDto(
                contact.getFirstName(),
                contact.getLastName(),
                contact.getPhoneNumber(),
                contact.getEmail(),
                contact.getBirthdate()
        );
    }

    // Example method to convert ContactDto to Contact
    public static Contact fromDto(ContactDto contactDto) {
        return new Contact(
                null,
                contactDto.firstName(),
                contactDto.lastName(),
                contactDto.phoneNumber(),
                contactDto.email(),
                contactDto.birthdate(),
                null // User is not set here, it should be set in the service layer
        );
    }
}
