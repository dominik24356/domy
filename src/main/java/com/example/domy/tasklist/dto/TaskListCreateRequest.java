package com.example.domy.tasklist.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TaskListCreateRequest {
    @Size(max = 100)
    @NotBlank
    private String listName;
}
