package com.corelia.address_book.controller;

import com.corelia.address_book.dto.AuthResponse;
import com.corelia.address_book.dto.UserDto.LoginUserDto;
import com.corelia.address_book.dto.UserDto.RegisterUserDto;
import com.corelia.address_book.model.User;
import com.corelia.address_book.service.AuthenticationService;
import com.corelia.address_book.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final JwtUtil jwtUtil;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtUtil jwtUtil, AuthenticationService authenticationService) {
        this.jwtUtil = jwtUtil;
        this.authenticationService = authenticationService;
    }

    //sign up takes no authentication
    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody @Valid RegisterUserDto registerUserDto) {
        User newUser = authenticationService.signUp(registerUserDto);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginUserDto loginUserDto) {
        User authenticateUser = authenticationService.authenticateLogin(loginUserDto);
        String token = jwtUtil.generateToken(authenticateUser);
        AuthResponse authResponse = new AuthResponse(token, jwtUtil.extractExpiration(token).toString());
        return ResponseEntity.ok(authResponse);
    }
}
