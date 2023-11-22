package com.example.domy.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiException extends RuntimeException {
    private HttpStatus status;
    private String message;


    public ApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ApiException() {
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
