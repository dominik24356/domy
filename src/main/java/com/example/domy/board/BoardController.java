package com.example.domy.board;

import com.example.domy.board.dto.BoardCreateRequest;
import com.example.domy.board.dto.BoardDto;
import com.example.domy.board.dto.BoardUpdateRequest;
import com.example.domy.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping( "/api")
public class BoardController {

    private final BoardService boardService;


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
    public ResponseEntity<List<BoardDto>> getAllBoardsByUserId(@PathVariable(name = "user-id") Long userId) {
        return ResponseEntity.ok(boardService.getBoardsByUserId(userId));
    }

//    @GetMapping("/boards")
//    @PreAuthorize("#username == authentication.principal.username or hasRole('ROLE_ADMIN')")
//    public ResponseEntity<List<BoardDto>> getBoardsByUserUsername(@RequestParam(name = "username") String username) {
//        return ResponseEntity.ok(boardService.getBoardsByUserUsername(username));
//    }

    @GetMapping("/boards")
    public ResponseEntity<List<BoardDto>> getAllBoardsForLoggedInUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(boardService.getBoardsByUserUsername(user.getUsername()));
    }

    @PostMapping("/boards")
    public ResponseEntity<BoardDto> createBoard(@Valid @RequestBody BoardCreateRequest boardCreateRequest, @AuthenticationPrincipal User user) {
        return ResponseEntity.created(URI.create("/api/boards/" + boardService.createBoard(boardCreateRequest, user).getBoardId())).build();
    }

    @DeleteMapping("/boards/{board-id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or @boardService.isBoardOwner(authentication, #boardId)")
    public ResponseEntity<Void> deleteBoardById(@PathVariable(name = "board-id") Long boardId) {
        boardService.deleteBoardById(boardId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/boards/{board-id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or @boardService.isBoardOwner(authentication, #boardId)")
    public ResponseEntity<Void> updateBoard(@PathVariable(name = "board-id") Long boardId, @Valid @RequestBody BoardUpdateRequest boardUpdateRequest) {
        boardService.updateBoard(boardId, boardUpdateRequest);
        return ResponseEntity.noContent().build();
    }


}
