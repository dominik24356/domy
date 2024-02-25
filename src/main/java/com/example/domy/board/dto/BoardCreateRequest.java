package com.example.domy.board.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class BoardCreateRequest {

    @Size(min=1,max = 100, message = "Board name must be between 1 and 100 characters")
    @NotBlank(message = "Board name cannot be blank")
    private final String boardName;

    public BoardCreateRequest() {
        this.boardName = "";
    }
}
