package com.example.domy.task;

import com.example.domy.task.dto.TaskDto;
import com.example.domy.task.exception.TaskNotFoundException;
import com.example.domy.user.User;
import com.example.domy.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    private UserService userService;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper, UserService userService) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userService = userService;
    }

    public TaskDto getTaskById(Long taskId) {
        return taskMapper.mapToTaskDto(taskRepository.getByTaskId(taskId).orElseThrow(() -> new TaskNotFoundException(taskId))) ;
    }

    public List<TaskDto> getTasksByUserId(Long userId) {
        User user = userService.getUserById(userId);
        return taskMapper.mapToListOfTaskDto(taskRepository.findTasksByUser(user)) ;
    }
}
