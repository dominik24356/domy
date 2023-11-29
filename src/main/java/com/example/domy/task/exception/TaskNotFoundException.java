package com.example.domy.task.exception;

import com.example.domy.exception.ApiException;
import org.springframework.http.HttpStatus;

public class TaskNotFoundException extends ApiException {
    public TaskNotFoundException(Long userId) {
        super(HttpStatus.NOT_FOUND, String.format("task of id %d not found", userId));
    }
}
