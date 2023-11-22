package com.example.domy.user.exception;

import com.example.domy.exception.ApiException;
import org.springframework.http.HttpStatus;


public class UserNotFoundException extends ApiException {

    public UserNotFoundException(Long userId) {
        super(HttpStatus.NOT_FOUND, String.format("user of id %d not found", userId));
    }
}