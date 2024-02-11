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

    public List<BoardDto> getBoardsByUserUsername(String username) {
        if (username.isBlank()){
            throw new IllegalArgumentException("Username cannot be blank");
        }

        User user = userService.getUserByUsername(username);
        return boardMapper.mapToListOfBoardDto(boardRepository.getBoardsByUser(user));
    }

    public BoardDto createBoard(String title, User user) {
        if(title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }

        Board board = new Board();
        board.setBoardName(title);
        board.setUser(user);


        return boardMapper.mapToBoardDto(boardRepository.save(board));
    }
}
