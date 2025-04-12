package com.corelia.address_book.dto;


public class AuthResponse {
    private String token;

    private String expirationDate;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public AuthResponse(String token, String expirationDate) {
        this.token = token;
        this.expirationDate = expirationDate;
    }
}
