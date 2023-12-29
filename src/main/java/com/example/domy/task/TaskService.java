package com.example.domy.task;

import com.example.domy.task.dto.TaskDto;
import com.example.domy.task.exception.TaskNotFoundException;
import com.example.domy.tasklist.TaskListService;
import com.example.domy.user.User;
import com.example.domy.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;
    private UserService userService;

    private TaskListService taskListService;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper, UserService userService, TaskListService taskListService) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userService = userService;
        this.taskListService = taskListService;
    }

    public TaskDto getTaskById(Long taskId) {
        Task task = taskRepository.findByTaskId(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
        return taskMapper.mapToTaskDto(task);
    }

    public List<TaskDto> getTasksByUserId(Long userId) {
        User user = userService.getUserById(userId);
        return taskMapper.mapToListOfTaskDto(taskRepository.findTasksByUser(user)) ;
    }

    public void addTask(String taskName, Long listId) {
        taskListService.addTask(taskName, listId);
    }
}
