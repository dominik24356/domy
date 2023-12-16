package com.example.domy.tasklist.exception;

import com.example.domy.exception.ApiException;
import org.springframework.http.HttpStatus;

public class TaskListNotFoundException extends ApiException {

    public TaskListNotFoundException(Long taskListId) {
        super(HttpStatus.NOT_FOUND, String.format("taskList of id %d not found", taskListId));
    }
}