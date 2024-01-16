package com.example.domy.task.dto;


import com.example.domy.task.Task;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class TaskDto {
    private Long taskId;

    private String taskName;
    private String description;
    private Timestamp dueDate;
    private Task.TaskStatus status;
    private List<CommentDto> comments;
    private List<AttachmentDto> attachments;
    private List<LabelDto> labels;



}
