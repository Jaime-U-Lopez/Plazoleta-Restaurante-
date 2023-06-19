package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponseTokenDto {
    private String token;

    public JwtResponseTokenDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
