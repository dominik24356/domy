package com.example.domy.tasklist;

import com.example.domy.board.Board;
import com.example.domy.board.BoardService;
import com.example.domy.exception.EntityNotFoundException;
import com.example.domy.tasklist.dto.TaskListDto;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskListService {

    BoardService boardService;
    TaskListRepository taskListRepository;
    TaskListMapper taskListMapper;

    public TaskListService(BoardService boardService, TaskListRepository taskListRepository, TaskListMapper taskListMapper) {
        this.boardService = boardService;
        this.taskListRepository = taskListRepository;
        this.taskListMapper = taskListMapper;
    }

    public List<TaskListDto> getAllTaskListsDtoByBoardId(Long boardId) {
        Board board = boardService.getBoardById(boardId);
        return  taskListMapper.mapToTaskListsDto(taskListRepository.getTaskListsByBoard(board));
    }

    @Transactional
    public void deleteTaskListById(Long taskListId) {
        TaskList taskList = getTaskListById(taskListId);
        taskListRepository.delete(taskList);
    }

    public void createTaskList(String title, Long boardId) {

        if(!title.isBlank()) {
            Board board = boardService.getBoardById(boardId);

            TaskList taskList = TaskList.builder()
                    .listName(title)
                    .board(board)
                    .build();

            taskListRepository.save(taskList);
        }
    }

    public TaskList getTaskListById(Long id) {
        return taskListRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(TaskList.class, "id", id.toString()));
    }

    public void addTask(String taskName, Long listId) {
        TaskList taskList = getTaskListById(listId);
        taskList.addTask(taskName);
        taskListRepository.save(taskList);
    }
}
