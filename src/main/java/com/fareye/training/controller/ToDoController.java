package com.fareye.training.controller;

import com.fareye.training.model.ToDo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoController {

    List<ToDo> toDoList = new ArrayList<>();

    @GetMapping("/todo")
    public List<ToDo> todo(){
        return toDoList;
    }

    @GetMapping("/todo1")
    public List<ToDo> todo1(@RequestParam String gmail){
        List<ToDo> list = new ArrayList<>();
        for(int i=0;i<toDoList.size();i++){
            if(gmail.equals(toDoList.get(i).getUser().getEmail())){
                list.add(toDoList.get(i));
            }
        }
        return list;
    }

    @PostMapping("/todo")
    public List<ToDo> todo(@RequestBody ToDo toDo){
        toDoList.add(toDo);
        return toDoList;
    }

}