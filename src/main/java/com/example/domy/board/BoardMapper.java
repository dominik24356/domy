package com.example.domy.board;

import com.example.domy.board.dto.BoardDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoardMapper {

    BoardDto mapToBoardDto(Board board);
}
