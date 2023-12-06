package com.example.domy.tasklist;

import com.example.domy.board.Board;
import com.example.domy.board.BoardService;
import com.example.domy.tasklist.dto.TaskListDto;
import org.springframework.stereotype.Service;

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
}
