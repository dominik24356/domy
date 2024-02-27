package com.example.domy.board.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class BoardUpdateRequest {
    private final String boardName;

    @JsonCreator
    public BoardUpdateRequest(@JsonProperty String boardName) {
        this.boardName = boardName;
    }
}
