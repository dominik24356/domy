package com.example.domy.task.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CommentDto {

    private Long commentId;

    private String content;

    private Timestamp createdAt;

    private String authorName;


}
