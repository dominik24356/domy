package com.example.domy.task;

import com.example.domy.board.Board;
import com.example.domy.board.BoardRepository;
import com.example.domy.task.dto.TaskDto;
import com.example.domy.task.exception.TaskNotFoundException;
import com.example.domy.tasklist.TaskList;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    private BoardRepository boardRepository;
    private TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, BoardRepository boardRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.boardRepository = boardRepository;
        this.taskMapper = taskMapper;
    }

    public TaskDto getTaskById(Long taskId) {
        return taskMapper.mapToTaskDto(taskRepository.getByTaskId(taskId).orElseThrow(() -> new TaskNotFoundException(taskId))) ;
    }

    public List<TaskDto> getTasksByUserId(Long userId) {
        return taskMapper.mapToListOfTaskDto(taskRepository.findTasksByUserId(userId)) ;
    }
}
