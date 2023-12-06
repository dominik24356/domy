package com.example.domy.tasklist;


import com.example.domy.tasklist.dto.TaskListDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskListMapper {


    List<TaskListDto> mapToTaskListsDto(List<TaskList> taskLists);
}
