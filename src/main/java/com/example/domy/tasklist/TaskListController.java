package com.example.domy.tasklist;

import com.example.domy.tasklist.dto.CreateTaskListDto;
import com.example.domy.tasklist.dto.TaskListDto;
import com.example.domy.tasklist.exception.TaskListNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
          try {
               taskListService.deleteTaskListById(taskListId);
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          } catch (Exception ex) {
               throw new TaskListNotFoundException(taskListId);
          }

     }

     @PostMapping("/task-lists")
     ResponseEntity<Void> createTaskList(@RequestBody CreateTaskListDto createTaskListDto) {

          try {
               taskListService.createTaskList(createTaskListDto.getTitle(), createTaskListDto.getId());
          } catch (Exception ex) {
               return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
          }

          return new ResponseEntity<>(HttpStatus.CREATED);
     }
}
