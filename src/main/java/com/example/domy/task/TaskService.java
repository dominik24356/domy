package com.example.domy.task;

import com.example.domy.board.BoardService;
import com.example.domy.exception.EntityNotFoundException;
import com.example.domy.task.dto.TaskDto;
import com.example.domy.task.dto.TaskUpdateRequest;
import com.example.domy.task.label.LabelMapper;
import com.example.domy.task.mapper.TaskMapper;
import com.example.domy.user.User;
import com.example.domy.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserService userService;
    private final BoardService boardService;
    private final LabelMapper labelMapper;



    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper, UserService userService, BoardService boardService, LabelMapper labelMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userService = userService;
        this.labelMapper = labelMapper;
        this.boardService = boardService;
    }

    public TaskDto getTaskById(Long taskId) {
        return taskMapper.mapToTaskDto(getTaskByIdInternal(taskId));
    }

    private Task getTaskByIdInternal(Long taskId) {
        return taskRepository.findByTaskId(taskId).orElseThrow(() -> new EntityNotFoundException(Task.class, "id", taskId.toString()));
    }

    public List<TaskDto> getTasksByUserId(Long userId) {
        User user = userService.getUserById(userId);
        return taskMapper.mapToListOfTaskDto(taskRepository.findTasksByUser(user)) ;
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

    public boolean isTaskOwner(Authentication authentication, Long taskId) {
        return boardService.isBoardOwner(authentication, getTaskByIdInternal(taskId).getTaskList().getBoard());
    }


}
