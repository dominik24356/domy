package com.example.domy.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleException(ApiException ex) {
        return ResponseEntity.status(ex.getStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        ErrorResponse.builder()
                                .message(ex.getMessage())
                                .build()
                );
    }

    @Builder
    @Getter
    public static class ErrorResponse {
        private String message;
    }

}
