package com.example.domy.tasklist.dto;

import com.example.domy.task.dto.TaskDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaskListDto {

    private Long listId;

    private String listName;

    private List<TaskDto> tasks;
}
