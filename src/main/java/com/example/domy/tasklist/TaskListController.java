package com.example.domy.tasklist;

import com.example.domy.tasklist.dto.TaskListDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TaskListController {

     TaskListService taskListService;

     public TaskListController(TaskListService taskListService) {
          this.taskListService = taskListService;
     }

     @GetMapping("/boards/{board-id}/task-lists")
     ResponseEntity<List<TaskListDto>> getAllTaskListsByBoardId(@PathVariable(name = "board-id") Long boardId){
          return ResponseEntity.ok(taskListService.getAllTaskListsDtoByBoardId(boardId));
     }
}
