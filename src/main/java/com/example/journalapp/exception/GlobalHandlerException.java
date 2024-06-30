package com.example.journalapp.exception;

import com.example.journalapp.payloads.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<APIResponse> resourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        return new ResponseEntity<>
                (new APIResponse(message,false,HttpStatus.NOT_FOUND.toString()), HttpStatus.NOT_FOUND);
        }
    }
