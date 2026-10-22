package org.example.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.taskmanager.model.Status;

public class TaskRequest {
    @NotBlank(message = "Title cannot be blank")
    @Size(max = 100, message = "Title cannot exceed hundred")
    private String title;
    @Size(max = 500, message = "Description cannot exceed 500 words ")
    private String description;
    private Status status = Status.TODO;
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public TaskRequest() {}


}
