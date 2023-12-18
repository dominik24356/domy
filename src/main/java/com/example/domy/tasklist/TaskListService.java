package com.example.domy.tasklist;

import com.example.domy.board.Board;
import com.example.domy.board.BoardService;
import com.example.domy.task.Task;
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
        taskListRepository.deleteById(taskListId);
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
}
