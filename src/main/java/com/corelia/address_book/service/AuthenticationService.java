package com.corelia.address_book.service;


import com.corelia.address_book.dto.UserDto.LoginUserDto;
import com.corelia.address_book.dto.UserDto.RegisterUserDto;
import com.corelia.address_book.model.User;
import com.corelia.address_book.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signUp(RegisterUserDto registerUserDto) {
        User user = new User();
        user.setUserName(registerUserDto.getUserName());
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        return userRepository.save(user);
    }

 public User authenticateLogin(LoginUserDto loginUserDto) {
     // Check if the user is already authenticated and the token is still valid
     User existingUser = userRepository.findByEmail(loginUserDto.getEmail())
             .orElseThrow(() -> new RuntimeException("User not found"));

     // Authenticate the user using the AuthenticationManager
     Authentication authentication = authenticationManager.authenticate(
             new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword())
     );

     // Retrieve the authenticated user from the database
     return userRepository.findByEmail(loginUserDto.getEmail())
             .orElseThrow(() -> new RuntimeException("User not found after authentication"));
 }

}
