package com.example.domy.task.dto;


import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class TaskDto {
    private Long taskId;

    private String taskName;
    private String description;
    private Date dueDate;
    private String status;
    private CommentDto[] comments;
    private AttachmentDto[] attachments;
    private LabelDto[] labels;



}
