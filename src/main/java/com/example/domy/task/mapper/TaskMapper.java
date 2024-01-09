package com.example.domy.task.mapper;

import com.example.domy.task.Task;
import com.example.domy.task.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = CommentMapper.class)
public interface TaskMapper {

    @Mapping(target = "comments", source = "comments")
    TaskDto mapToTaskDto(Task task);

    List<TaskDto> mapToListOfTaskDto(List<Task> tasks);
}
