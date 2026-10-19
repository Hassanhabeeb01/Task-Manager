package org.example.taskmanager.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.example.taskmanager.dto.ExceptionResponseDto;
import org.example.taskmanager.dto.ValidationResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleGenericException(Exception e, HttpServletRequest http){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                "Something went wrong",
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                http.getRequestURI()
        );
      return   ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body(exceptionResponseDto);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException e, HttpServletRequest http){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                http.getRequestURI()
        );
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponseDto);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest http){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                e.getMessage(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                HttpStatus.NOT_FOUND.value(),
                http.getRequestURI()
        );
        return  ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionResponseDto);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException me,
                                                                                       HttpServletRequest http){
        Map<String,String> fieldErrors = new HashMap<>();
        me.getBindingResult().getFieldErrors()
                .forEach(error-> fieldErrors.put(error.getField(), error.getDefaultMessage()));

        ValidationResponseDto validationResponseDto = new ValidationResponseDto(
                LocalDateTime.now(),
                "Validation Failed",
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                HttpStatus.BAD_REQUEST.value(),
                http.getRequestURI(),
                fieldErrors

        );
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(validationResponseDto);
    }
}
