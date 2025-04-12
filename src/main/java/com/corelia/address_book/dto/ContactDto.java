package com.corelia.address_book.dto;

import java.time.LocalDate;

//record for immutable data transfer object
public record ContactDto(
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        LocalDate birthdate
) {
}
