package com.corelia.address_book.dto.UserDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterUserDto extends UserDto{


    private String userName;

    public RegisterUserDto(

            @Email(message = "Invalid email address")
            @NotBlank(message = "Email is mandatory")
            String email,

            @NotBlank(message = "Password is mandatory")
            @Size(min = 8, message = "Password must be at least 8 characters long")
            String password,

            @NotBlank(message = "Username is mandatory")
            String userName) {
        super(email, password);
        this.userName = userName;
    }

    public @NotBlank(message = "Username is mandatory") String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank(message = "Username is mandatory") String userName) {
        this.userName = userName;
    }
}
