package com.example.openschoolthirdhomework.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandlers {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(final ResourceNotFoundException ex) {
        log.error("not found entity");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("Access-Control-Allow-Origin", "*")
                .body(ex.message);
    }

    @ExceptionHandler(IdAlreadyExistException.class)
    public ResponseEntity<Object> handleIdAlreadyExistException(final IdAlreadyExistException ex) {
        log.error("id already exist");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header("Access-Control-Allow-Origin", "*")
                .body(ex.message);
    }

}
