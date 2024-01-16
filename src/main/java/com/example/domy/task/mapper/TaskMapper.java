package com.example.domy.task.mapper;

import com.example.domy.task.Task;
import com.example.domy.task.dto.TaskDto;
import com.example.domy.task.dto.TaskUpdateRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = CommentMapper.class)
public interface TaskMapper {

    @Mapping(target = "comments", source = "comments")
    TaskDto mapToTaskDto(Task task);

    List<TaskDto> mapToListOfTaskDto(List<Task> tasks);

    Task mapToTask(TaskDto taskDto);

    @Mapping(target = "taskName", source = "taskName")
    @Mapping(target = "description", source = "description", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(target = "dueDate", source = "dueDate", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(target = "status", source = "status")
    void updateTaskFromDto(TaskUpdateRequest dto, @MappingTarget Task taskToUpdate);

}
