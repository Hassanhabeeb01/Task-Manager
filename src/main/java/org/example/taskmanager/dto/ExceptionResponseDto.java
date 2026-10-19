package org.example.taskmanager.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ExceptionResponseDto {
    private LocalDateTime timestamp;
    private String message;
    private String error;
    private int status;
    private String path;

    public ExceptionResponseDto(LocalDateTime timestamp, String message, String error, int status, String path) {
        this.timestamp = timestamp;
        this.message = message;
        this.error = error;
        this.status = status;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
