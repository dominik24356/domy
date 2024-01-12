package com.example.domy.tasklist;

import com.example.domy.tasklist.dto.TaskListCreateRequest;
import com.example.domy.tasklist.dto.TaskListDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskListController {

     TaskListService taskListService;

     public TaskListController(TaskListService taskListService) {
          this.taskListService = taskListService;
     }

     @GetMapping("/boards/{board-id}/task-lists")
     public ResponseEntity<List<TaskListDto>> getAllTaskListsByBoardId(@PathVariable(name = "board-id") Long boardId){
          return ResponseEntity.ok(taskListService.getAllTaskListsDtoByBoardId(boardId));
     }

     @DeleteMapping("/task-lists/{task-list-id}")
     ResponseEntity<Void> deleteTaskListById(@PathVariable(name = "task-list-id") Long taskListId) {
          taskListService.deleteTaskListById(taskListId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);

     }

     @PostMapping("/boards/{board-id}/task-lists")
     ResponseEntity<Void> createTaskList(@Valid @RequestBody TaskListCreateRequest createRequest, @PathVariable(name = "board-id") Long boardId) {
          taskListService.createTaskList(createRequest.getListName(), boardId);
          return new ResponseEntity<>(HttpStatus.CREATED);
     }
}
