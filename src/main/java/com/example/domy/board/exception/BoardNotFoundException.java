package com.example.domy.board.exception;

import com.example.domy.exception.ApiException;
import org.springframework.http.HttpStatus;

public class BoardNotFoundException extends ApiException {

    public BoardNotFoundException(Long boardId) {
        super(HttpStatus.NOT_FOUND, String.format("board of id %d not found", boardId));
    }
}
