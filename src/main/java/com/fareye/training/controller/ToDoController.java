package com.fareye.training.controller;
import com.fareye.training.model.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoController {

    List<ToDo> toDoList = new ArrayList<>();

    @GetMapping("/todo")
    public List<ToDo> todo() throws  NullPointerException{
        String s=null;
        System.out.println(s.length());
        return toDoList;
    }

    @GetMapping("/todo1")
    public List<ToDo> todo1(@RequestParam String gmail){
        List<ToDo> list = new ArrayList<>();
        for(int i=0;i<toDoList.size();i++){
            if(gmail.equals(toDoList.get(i).getUserMail())){
                list.add(toDoList.get(i));
            }
        }
        return list;
    }

    @PostMapping("/todo")
    public ResponseEntity<List<ToDo>> todo(@Valid @RequestBody ToDo toDo){

        toDoList.add(toDo);
        return new ResponseEntity<>(toDoList, HttpStatus.OK);
    }

}