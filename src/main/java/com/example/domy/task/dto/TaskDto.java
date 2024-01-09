package com.example.domy.task.dto;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class TaskDto {
    private Long taskId;

    private String taskName;
    private String description;
    private Timestamp dueDate;
    private String status;
    private List<CommentDto> comments;
    private List<AttachmentDto> attachments;
    private List<LabelDto> labels;



}
