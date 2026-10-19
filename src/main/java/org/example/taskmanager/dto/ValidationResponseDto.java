package org.example.taskmanager.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationResponseDto {
    private LocalDateTime timestamp;
    private String message;
    private String error;
    private int status;
    private String path;

    public Map<String, String> getErrorList() {
        return errorList;
    }

    public ValidationResponseDto(LocalDateTime timestamp, String message, String error, int status, String path, Map<String, String> errorList) {
        this.timestamp = timestamp;
        this.message = message;
        this.error = error;
        this.status = status;
        this.path = path;
        this.errorList = errorList;
    }

    public void setErrorList(Map<String, String> errorList) {
        this.errorList = errorList;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    private Map<String,String> errorList;

}
