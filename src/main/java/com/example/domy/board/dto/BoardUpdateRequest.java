package com.example.domy.board.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class BoardUpdateRequest {


    @Size(min=1,max = 100)
    @NotBlank
    private final String boardName;

    @JsonCreator
    public BoardUpdateRequest(@JsonProperty String boardName) {
        this.boardName = boardName;
    }
}
