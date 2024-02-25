package com.example.domy.tasklist;

import com.example.domy.tasklist.dto.TaskListCreateRequest;
import com.example.domy.tasklist.dto.TaskListDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskListController {

     TaskListService taskListService;

     public TaskListController(TaskListService taskListService) {
          this.taskListService = taskListService;
     }

     @GetMapping("/boards/{board-id}/task-lists")
     @PreAuthorize("@boardService.isBoardOwner(authentication, #boardId) or hasRole('ROLE_ADMIN')")
     public ResponseEntity<List<TaskListDto>> getAllTaskListsByBoardId(@PathVariable(name = "board-id") Long boardId) {
          return ResponseEntity.ok(taskListService.getAllTaskListsByBoardId(boardId));
     }

     @DeleteMapping("/task-lists/{task-list-id}")
     @PreAuthorize("@taskListService.isUserOwnerOfList(authentication, #taskListId) or hasRole('ROLE_ADMIN')")
     public ResponseEntity<Void> deleteTaskListById(@PathVariable(name = "task-list-id") Long taskListId) {
          taskListService.deleteTaskListById(taskListId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

     @PostMapping("/boards/{board-id}/task-lists")
     @PreAuthorize("@boardService.isBoardOwner(authentication, #boardId) or hasRole('ROLE_ADMIN')")
     public ResponseEntity<Void> createTaskList(@Valid @RequestBody TaskListCreateRequest createRequest, @PathVariable(name = "board-id") Long boardId) {
          TaskListDto taskListDto = taskListService.addTaskListToBoard(createRequest, boardId);
            return ResponseEntity.created(URI.create("/api/task-lists/" + taskListDto.getListId())).build();

     }

     @GetMapping("/task-lists/{task-list-id}")
     @PreAuthorize("@taskListService.isUserOwnerOfList(authentication, #taskListId) or hasRole('ROLE_ADMIN')")
     public ResponseEntity<TaskListDto> getTaskListById(@PathVariable(name = "task-list-id") Long taskListId) {
          return ResponseEntity.ok(taskListService.getTaskListDtoById(taskListId));
     }

}
