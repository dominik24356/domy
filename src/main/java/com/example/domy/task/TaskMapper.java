package com.example.domy.task;

import com.example.domy.task.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {

    TaskDto mapToTaskDto(Task task);
}
