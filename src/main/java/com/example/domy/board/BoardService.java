package com.example.domy.board;

import com.example.domy.board.dto.BoardDto;
import com.example.domy.exception.EntityNotFoundException;
import com.example.domy.user.User;
import com.example.domy.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;
    private BoardMapper boardMapper;

    private UserService userService;

    public BoardService(BoardRepository boardRepository, BoardMapper boardMapper, UserService userService) {
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
        this.userService = userService;
    }

    public boolean isBoardOwner(Authentication authentication, Long boardId) {
        User currentUser = (User) authentication.getPrincipal();
        Board board = getBoardById(boardId);

        return currentUser.getUserId().equals(board.getUser().getUserId());
    }

    public boolean isBoardOwner(Authentication authentication, Board board) {
        User currentUser = (User) authentication.getPrincipal();

        return currentUser.getUserId().equals(board.getUser().getUserId());
    }

    public BoardDto getBoardDtoById(Long boardId) {
        return  boardMapper.mapToBoardDto(getBoardById(boardId));
    }

    public Board getBoardById(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new EntityNotFoundException(Board.class, "id", boardId.toString()));
    }

    public List<BoardDto> getBoardsByUserId(Long userId) {
        User user = userService.getUserById(userId);
        return boardMapper.mapToListOfBoardDto(boardRepository.getBoardsByUser(user)) ;
    }
}
