package com.example.domy.board;

import com.example.domy.board.dto.BoardDto;
import com.example.domy.board.exception.BoardNotFoundException;
import com.example.domy.user.User;
import com.example.domy.user.UserService;
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

    public BoardDto getBoardDtoById(Long boardId) {
        return  boardMapper.mapToBoardDto(getBoardById(boardId));
    }

    public Board getBoardById(Long boardId) {
        return boardRepository.getByBoardId(boardId).orElseThrow(() -> new BoardNotFoundException(boardId));
    }

    public List<BoardDto> getBoardsByUserId(Long userId) {
        User user = userService.getUserById(userId);
        return boardMapper.mapToListOfBoardDto(boardRepository.getBoardsByUser(user)) ;
    }
}
