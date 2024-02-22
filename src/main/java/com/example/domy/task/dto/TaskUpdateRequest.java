package com.example.domy.task.dto;

import com.example.domy.task.Task;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
public class TaskUpdateRequest {
    @NotBlank(message = "Task name cannot be blank")
    @Size(min=1,max = 200, message = "Task name cannot be longer than 200 characters")
    private String taskName;
    @Size(max = 1000, message = "Description cannot be longer than 1000 characters")
    private String description;
    private Timestamp dueDate;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Task status cannot be null")
    private Task.TaskStatus status;


}
