package com.example.domy.board;

import com.example.domy.board.dto.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BoardController {

    BoardService boardService;


    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @GetMapping("/boards/{boardId}")
    public ResponseEntity<BoardDto> getBoardById(@PathVariable Long boardId) {
        return ResponseEntity.ok(boardService.getBoardById(boardId));
    }

    @GetMapping("/users/{userId}/boards")
    public ResponseEntity<List<BoardDto>> getBoardsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(boardService.getBoardsByUserId(userId));
    }


}
