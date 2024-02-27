package com.example.domy.tasklist;

import com.example.domy.board.Board;
import com.example.domy.board.BoardService;
import com.example.domy.exception.EntityNotFoundException;
import com.example.domy.task.Task;
import com.example.domy.task.dto.TaskDto;
import com.example.domy.task.mapper.TaskMapper;
import com.example.domy.tasklist.dto.TaskListCreateRequest;
import com.example.domy.tasklist.dto.TaskListDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskListService {

    private final BoardService boardService;
    private final TaskListRepository taskListRepository;
    private final TaskListMapper taskListMapper;

    private final TaskMapper taskMapper;

    public TaskListService(BoardService boardService, TaskListRepository taskListRepository, TaskListMapper taskListMapper, TaskMapper taskMapper) {
        this.boardService = boardService;
        this.taskListRepository = taskListRepository;
        this.taskListMapper = taskListMapper;
        this.taskMapper = taskMapper;
    }

    public List<TaskListDto> getAllTaskListsByBoardId(Long boardId) {
        Board board = boardService.getBoardById(boardId);
        return  taskListMapper.mapToTaskListsDto(taskListRepository.getTaskListsByBoard(board));
    }

    @Transactional
    public void deleteTaskListById(Long taskListId) {
        try {
            taskListRepository.deleteById(taskListId);
        } catch (Exception e) {
            throw new EntityNotFoundException(TaskList.class, "id", taskListId.toString());
        }
    }

    @Transactional
    public TaskListDto addTaskListToBoard(TaskListCreateRequest request, Long boardId) {
        Board board = boardService.getBoardById(boardId);
        TaskList taskList = TaskList.builder()
                .listName(request.getListName().trim())
                .board(board)
                .build();

        return taskListMapper.mapToTaskListDto(taskListRepository.save(taskList));
    }

    private TaskList getTaskListById(Long id) {
        return taskListRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(TaskList.class, "id", id.toString()));
    }

    public TaskListDto getTaskListDtoById(Long id) {
        return taskListMapper.mapToTaskListDto(getTaskListById(id));
    }

    @Transactional
    public TaskDto addTaskToList(String taskName, Long listId) {
        TaskList taskList = getTaskListById(listId);
        Task task = taskList.addTask(taskName.trim());
        taskListRepository.save(taskList);
        return taskMapper.mapToTaskDto(task);
    }

    public boolean isUserOwnerOfList(Authentication authentication, Long listId) {
        return boardService.isBoardOwner(authentication, getTaskListById(listId).getBoard());
    }
}
