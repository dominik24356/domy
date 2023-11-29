package com.example.domy.task;

import com.example.domy.task.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {

    TaskDto mapToTaskDto(Task task);

    List<TaskDto> mapToListOfTaskDto(List<Task> tasks);

}
