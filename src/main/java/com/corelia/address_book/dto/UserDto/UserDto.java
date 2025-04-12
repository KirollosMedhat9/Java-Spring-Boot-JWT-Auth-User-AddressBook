package com.corelia.address_book.dto.UserDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public abstract class UserDto {


    @Email(message = "Invalid email address")
    @NotBlank(message = "Email is mandatory")
    private String email;


    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  String getPassword() {
        return password;
    }

    public void setPassword( String password) {
        this.password = password;
    }


    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public UserDto() {
    }
}
