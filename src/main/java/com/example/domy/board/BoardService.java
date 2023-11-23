package com.example.domy.board;

import com.example.domy.board.dto.BoardDto;
import com.example.domy.board.exception.BoardNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private BoardRepository boardRepository;
    private BoardMapper boardMapper;

    public BoardService(BoardRepository boardRepository, BoardMapper boardMapper) {
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
    }

    public BoardDto getBoardById(Long id) {
        return  boardMapper.mapToBoardDto(boardRepository.getByBoardId(id).orElseThrow(() -> new BoardNotFoundException(id)));
    }
}
