package com.example.domy.task.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TaskCreateRequest {

    @NotBlank
    @Size(max = 200)
    private String taskName;
}
