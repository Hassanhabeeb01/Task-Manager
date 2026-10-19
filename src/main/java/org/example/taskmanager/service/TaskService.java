package org.example.taskmanager.service;

import org.example.taskmanager.dto.TaskRequest;
import org.example.taskmanager.dto.TaskResponse;
import org.example.taskmanager.entity.Task;
import org.example.taskmanager.exception.ResourceNotFoundException;
import org.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {
   private final TaskRepository taskRepository;

   public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task = mapToEntity(taskRequest);
        taskRepository.save(task);
        return taskResponse(task);
    }


    public List<TaskResponse> getAllResponses() {
        return taskRepository.findAll().stream().map(this::taskResponse).toList();
    }

    public TaskResponse getATask(Long id) {
       Task task = taskRepository.findById(id).orElseThrow(() ->
               new ResourceNotFoundException("Student with id " + id + " does not exist"));
       return this.taskResponse(task);
   }

   public TaskResponse updateTask(Long id,TaskRequest taskRequest) {
       Task task = taskRepository.findById(id).orElseThrow(() ->
               new ResourceNotFoundException("Student with id " + id + " does not exist"));
       task.setDescription(taskRequest.getDescription());
       task.setStatus(taskRequest.getStatus());
       task.setTitle(taskRequest.getTitle());
       task.setUpdatedDate(LocalDate.now());
       taskRepository.save(task);
        return taskResponse(task);
   }
   public void deleteTask(Long id) {
       Task task = taskRepository.findById(id).orElseThrow(() ->
               new ResourceNotFoundException("Student with id " + id + " does not exist"));
       taskRepository.delete(task);

   }

    private TaskResponse taskResponse(Task task) {
       TaskResponse taskResponse = new TaskResponse();
       taskResponse.setId(task.getId());
       taskResponse.setDescription(task.getDescription());
       taskResponse.setStatus(task.getStatus());
       taskResponse.setTitle(task.getTitle());
       taskResponse.setCreatedDate(task.getCreatedDate());
       taskResponse.setUpdatedDate(task.getUpdatedDate());
       return taskResponse;
    }

    private Task mapToEntity(TaskRequest taskRequest) {
        Task task = new Task();
        task.setDescription(taskRequest.getDescription());
        task.setStatus(taskRequest.getStatus());
        task.setTitle(taskRequest.getTitle());
        task.setCreatedDate(LocalDate.now());
        task.setUpdatedDate(LocalDate.now());
        return task;
    }
}
