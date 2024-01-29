package com.example.domy.task;

import com.example.domy.task.dto.TaskCreateRequest;
import com.example.domy.task.dto.TaskDto;
import com.example.domy.task.dto.TaskUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping( "/api")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/tasks/{task-id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable(name = "task-id") Long taskId) {
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }

    @GetMapping("/users/{user-id}/tasks")
    public ResponseEntity<List<TaskDto>> getTasksByUserId(@PathVariable(name = "user-id") Long userId) {
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }

    @PostMapping("/task-lists/{list-id}/tasks")
    public ResponseEntity<Void> addTaskToList(@Valid @RequestBody TaskCreateRequest createRequest, @PathVariable(name = "list-id") Long listId) {
        taskService.addTask(createRequest.getTaskName(), listId);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/tasks/{task-id}")
    public ResponseEntity<Void> updateTask(@PathVariable(name = "task-id") Long taskId,@Valid @RequestBody TaskUpdateRequest updateRequest) {
        taskService.updateTask(taskId, updateRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
