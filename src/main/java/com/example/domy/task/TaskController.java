package com.example.domy.task;

import com.example.domy.task.dto.*;
import com.example.domy.task.label.dto.LabelDto;
import com.example.domy.tasklist.TaskListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping( "/api")
public class TaskController {

    private final TaskService taskService;

    private final TaskListService taskListService;

    public TaskController(TaskService taskService, TaskListService taskListService) {
        this.taskService = taskService;
        this.taskListService = taskListService;
    }


    @GetMapping("/tasks/{task-id}")
    @PreAuthorize("@taskService.isTaskOwner(authentication, #taskId) or hasRole('ROLE_ADMIN')")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable(name = "task-id") Long taskId) {
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }

    @GetMapping("/users/{user-id}/tasks")
    @PreAuthorize("#userId == authentication.principal.userId or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<TaskDto>> getAllTasksByUserId(@PathVariable(name = "user-id") Long userId) {
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }

    @PostMapping("/task-lists/{list-id}/tasks")
    @PreAuthorize("@taskListService.isUserOwnerOfList(authentication, #listId) or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> addTaskToList(@Valid @RequestBody TaskCreateRequest createRequest, @PathVariable(name = "list-id") Long listId) {
        TaskDto taskDto = taskListService.addTaskToList(createRequest.getTaskName(), listId);
        return ResponseEntity.created(URI.create("/api/tasks/" + taskDto.getTaskId())).build();
    }

    @PutMapping("/tasks/{task-id}")
    @PreAuthorize("@taskService.isTaskOwner(authentication, #taskId) or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> updateTask(@PathVariable(name = "task-id") Long taskId,@Valid @RequestBody TaskUpdateRequest updateRequest) {
        taskService.updateTask(taskId, updateRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // add label to task
//    @PostMapping("/tasks/{task-id}/labels")
//    @PreAuthorize("@taskService.isTaskOwner(authentication, #taskId) or hasRole('ROLE_ADMIN')")
//    public ResponseEntity<Void> addLabelToTask(@PathVariable(name = "task-id") Long taskId, @RequestBody LabelCreateRequest labelCreateRequest) {
//        LabelDto labelDto = taskService.addLabelToTask(taskId, labelCreateRequest);
//        return ResponseEntity.created(URI.create("/api/labels/" + labelDto.getLabelId())).build();
//    }

    // add method to get label by id


}
