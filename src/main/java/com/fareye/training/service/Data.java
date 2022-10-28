package com.fareye.training.service;

import com.fareye.training.model.ToDo;
import com.fareye.training.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Data {

    public static long id=1;
    public List<User> users = new ArrayList<>();

    public List<ToDo> toDoList = new ArrayList<>();
}
