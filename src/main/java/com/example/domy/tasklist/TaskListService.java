package com.example.domy.tasklist;

import com.example.domy.board.Board;
import com.example.domy.board.BoardService;
import com.example.domy.tasklist.dto.TaskListDto;
import com.example.domy.tasklist.exception.TaskListNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        taskListRepository.deleteById(taskListId);
    }
}
