package com.example.domy.board;

import com.example.domy.board.dto.BoardDto;
import com.example.domy.tasklist.TaskListMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = TaskListMapper.class)
public interface BoardMapper {

    BoardDto mapToBoardDto(Board board);

    List<BoardDto> mapToListOfBoardDto(List<Board> boards);
}
