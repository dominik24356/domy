package com.example.domy.task.mapper;

import com.example.domy.task.Comment;
import com.example.domy.task.dto.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    @Mapping(source = "author.username", target = "authorName")
    CommentDto mapToCommentDto(Comment comment);

    List<CommentDto> mapToListOfCommentDto(List<Comment> comments);
}