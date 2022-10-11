package com.fareye.training.controller;

import com.fasterxml.classmate.TypeBindings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullExceptionHandle(NullPointerException ex){
        System.out.println("null pointer exception");
        String message = ex.getMessage();
        System.out.println(ex.getLocalizedMessage());
        return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
    }


    // next step is to return map instead of List in following code......!!!!!!
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> exceptionHandler(MethodArgumentNotValidException ex)
    {
        List list = ex.getBindingResult().getAllErrors().stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        System.out.println(ex);
        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exception(Exception ex){
        System.out.println(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
