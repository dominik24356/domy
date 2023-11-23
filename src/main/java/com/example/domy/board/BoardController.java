package com.example.domy.board;

import com.example.domy.board.dto.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    BoardService boardService;


    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @GetMapping("/boards/{id}")
    public ResponseEntity<BoardDto> getBoardById(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoardById(id));
    }
}
