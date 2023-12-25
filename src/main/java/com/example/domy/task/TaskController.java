package com.example.domy.task;

import com.example.domy.task.dto.AddTaskDto;
import com.example.domy.task.dto.TaskDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
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
    public ResponseEntity<Void> addTaskToList(@RequestBody AddTaskDto addTaskDto, @PathVariable(name = "list-id") Long listId) {
        taskService.addTask(addTaskDto.getTaskName(), listId);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


}
