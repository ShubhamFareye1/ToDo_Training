package com.fareye.training.exception;

public class UserNotFoundException extends RuntimeException{
     public UserNotFoundException(String errMsg){
         super(errMsg);
     }
}
