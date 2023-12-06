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


    @GetMapping("/boards/{board-id}")
    public ResponseEntity<BoardDto> getBoardById(@PathVariable(name = "board-id") Long boardId) {
        return ResponseEntity.ok(boardService.getBoardDtoById(boardId));
    }

    @GetMapping("/users/{user-id}/boards")
    public ResponseEntity<List<BoardDto>> getBoardsByUserId(@PathVariable(name = "user-id") Long userId) {
        return ResponseEntity.ok(boardService.getBoardsByUserId(userId));
    }


}
