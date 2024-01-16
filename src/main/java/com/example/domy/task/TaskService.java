package com.example.domy.task;

import com.example.domy.task.dto.TaskDto;
import com.example.domy.task.dto.TaskUpdateRequest;
import com.example.domy.task.exception.TaskNotFoundException;
import com.example.domy.task.mapper.TaskMapper;
import com.example.domy.tasklist.TaskListService;
import com.example.domy.user.User;
import com.example.domy.user.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return taskMapper.mapToTaskDto(getTaskByIdInternal(taskId));
    }

    private Task getTaskByIdInternal(Long taskId) {
        return taskRepository.findByTaskId(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
    }

    public List<TaskDto> getTasksByUserId(Long userId) {
        User user = userService.getUserById(userId);
        return taskMapper.mapToListOfTaskDto(taskRepository.findTasksByUser(user)) ;
    }

    public void addTask(String taskName, Long listId) {
        taskListService.addTask(taskName.trim(), listId);
    }

    @Transactional
    public void updateTask(Long taskId, TaskUpdateRequest updateRequest) {
        updateRequest.setTaskName(updateRequest.getTaskName().trim());

        if (updateRequest.getDescription() != null){
            updateRequest.setDescription(updateRequest.getDescription().trim());
        }


        Task taskToUpdate = getTaskByIdInternal(taskId);

        taskMapper.updateTaskFromDto(updateRequest, taskToUpdate);

        taskRepository.save(taskToUpdate);
    }
}
