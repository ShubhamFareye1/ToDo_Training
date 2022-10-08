package com.fareye.training.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullExceptionHandle(NullPointerException ex){
        System.out.println("null pointer exception");
        String message = ex.getMessage();
        System.out.println(ex.getLocalizedMessage());
        return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
        //return "Null Pointer Exception";
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> exceptionHandler(MethodArgumentNotValidException ex)
    {
        Map<String,String> response = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String filedMessage = error.getDefaultMessage();
            response.put(fieldName,filedMessage);
            System.out.println(fieldName+"->"+filedMessage);
        });
        System.out.println(response);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}
