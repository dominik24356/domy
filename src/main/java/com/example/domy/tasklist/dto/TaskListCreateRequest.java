package com.example.domy.tasklist.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TaskListCreateRequest {
    @Column(length = 100)
    @NotBlank
    private String listName;
}
