package com.example.domy.security.dto;

import lombok.Getter;

@Getter
public class AuthenticationRequest {
    private String username;
    private String password;
}
