package org.example.taskmanager.controller;

import jakarta.validation.Valid;
import org.example.taskmanager.dto.TaskRequest;
import org.example.taskmanager.dto.TaskResponse;
import org.example.taskmanager.entity.Task;
import org.example.taskmanager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskRequest taskRequest) {
        TaskResponse taskResponse = taskService.createTask(taskRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>>getAllTasks() {

        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllResponses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getATask(@PathVariable Long id) {

      TaskResponse taskResponse =  taskService.getATask(id);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id, @RequestBody TaskRequest taskRequest) {
         TaskResponse taskResponse = taskService.updateTask(id, taskRequest);
         return ResponseEntity.ok(taskResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return  ResponseEntity.noContent().build();
    }
}
