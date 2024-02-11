package com.example.domy.board;

import com.example.domy.board.dto.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api")
public class BoardController {

    BoardService boardService;


    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @GetMapping("/boards/{board-id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or @boardService.isBoardOwner(authentication, #boardId)")
    public ResponseEntity<BoardDto> getBoardById(@PathVariable(name = "board-id") Long boardId) {
        return ResponseEntity.ok(boardService.getBoardDtoById(boardId));
    }

    @GetMapping("/users/{user-id}/boards")
    @PreAuthorize("#userId == authentication.principal.userId or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<BoardDto>> getBoardsByUserId(@PathVariable(name = "user-id") Long userId) {
        return ResponseEntity.ok(boardService.getBoardsByUserId(userId));
    }

    @GetMapping("/users/boards")
    @PreAuthorize("#username == authentication.principal.username or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<BoardDto>> getBoardsByUserUsername(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok(boardService.getBoardsByUserUsername(username));
    }


}
