package com.example.domy.task.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class AttachmentDto {
    private Long attachmentId;
    private String link;
    private String name;
    private Timestamp createdAt;
}
