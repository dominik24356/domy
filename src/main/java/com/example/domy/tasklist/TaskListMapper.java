package com.example.domy.tasklist;


import com.example.domy.task.mapper.TaskMapper;
import com.example.domy.tasklist.dto.TaskListDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = TaskMapper.class)
public interface TaskListMapper {

    List<TaskListDto> mapToTaskListsDto(List<TaskList> taskLists);

    TaskListDto mapToTaskListDto(TaskList taskList);
}
