package com.example.domy.task.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TaskCreateRequest {

    @NotBlank
    @Column(length = 200)
    private String taskName;
}
