package com.example.domy.board;

import com.example.domy.board.dto.BoardDto;
import com.example.domy.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
