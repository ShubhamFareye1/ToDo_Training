package com.fareye.training.exception;

public class UserAlredyExistsException extends RuntimeException{
    public UserAlredyExistsException(String errMsg){
        super(errMsg);
    }
}
