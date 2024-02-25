package com.example.domy.task.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TaskCreateRequest {

    @NotBlank
    @Size(min=1,max = 200, message = "Task name must be between 1 and 200 characters")
    private String taskName;
}
