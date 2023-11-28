package com.example.domy.board;

import com.example.domy.board.dto.BoardDto;
import com.example.domy.board.exception.BoardNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;
    private BoardMapper boardMapper;

    public BoardService(BoardRepository boardRepository, BoardMapper boardMapper) {
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
    }

    public BoardDto getBoardById(Long boardId) {
        return  boardMapper.mapToBoardDto(boardRepository.getByBoardId(boardId).orElseThrow(() -> new BoardNotFoundException(boardId)));
    }

    public List<BoardDto> getBoardsByUserId(Long userId) {
        return boardMapper.mapToListOfBoardDto(boardRepository.getBoardsByUser_UserId(userId)) ;
    }
}
