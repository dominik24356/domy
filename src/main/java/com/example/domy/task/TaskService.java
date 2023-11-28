package com.example.domy.task;

import com.example.domy.task.dto.TaskDto;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public TaskDto getTaskById(Long taskId) {
        return taskMapper.mapToTaskDto(taskRepository.getById(taskId)) ;
    }
}
