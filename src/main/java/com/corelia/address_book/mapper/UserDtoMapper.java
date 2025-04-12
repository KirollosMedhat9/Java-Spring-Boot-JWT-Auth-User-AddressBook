package com.corelia.address_book.mapper;

import com.corelia.address_book.dto.UserDto.LoginUserDto;
import com.corelia.address_book.dto.UserDto.RegisterUserDto;
import com.corelia.address_book.dto.UserDto.UserDto;
import com.corelia.address_book.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    public static LoginUserDto toLoginDto(User user) {
        return new LoginUserDto(
                user.getEmail(),
                user.getPassword()
        );
    }

    public static RegisterUserDto toRegisterDto(User user) {
        return new RegisterUserDto(
                user.getEmail(),
                user.getPassword(),
                user.getUserName()
        );
    }

    public static User fromDto(RegisterUserDto userDto) {
        return new User(
                null,
                userDto.getUserName(),
                userDto.getEmail(),
                userDto.getPassword(),
                null,
                null,
                null
        );
    }
}
