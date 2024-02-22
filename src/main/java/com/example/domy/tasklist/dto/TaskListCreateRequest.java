package com.example.domy.tasklist.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TaskListCreateRequest {
    @Size(min=1, max = 100, message = "List name cannot be longer than 100 characters")
    @NotBlank(message = "List name cannot be blank")
    private String listName;
}
