package com.corelia.address_book.dto.UserDto;

import jakarta.validation.constraints.NotBlank;

public class LoginUserDto extends UserDto{


    public LoginUserDto() {
    }

    public LoginUserDto(String email, String password) {
        super(email, password);
    }
}
