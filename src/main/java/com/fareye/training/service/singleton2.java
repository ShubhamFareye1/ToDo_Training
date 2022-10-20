package com.fareye.training.service;


//without lazy initialization
public class singleton2 {
    private static volatile singleton2 instance = new singleton2();
    private singleton2(){}
    public static singleton2 getInstance(){
        return instance;
    }
}
