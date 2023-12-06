package com.example.domy.board.dto;

import com.example.domy.tasklist.dto.TaskListDto;
import com.example.domy.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardDto {

    private Long boardId;

    private String boardName;

    private List<TaskListDto> taskLists;
}
