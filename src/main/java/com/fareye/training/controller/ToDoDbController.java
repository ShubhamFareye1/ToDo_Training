package com.fareye.training.controller;
import com.fareye.training.model.ToDo;
import com.fareye.training.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoDbController {
   @Autowired
   ToDoService toDoService;

    @GetMapping("/list")
    public List<ToDo> toDoList(){
        return toDoService.toDoList();
    }
    @GetMapping("")
    public List<ToDo> toDoUserList(@RequestParam Integer userId){
        return toDoService.getTodos(userId);
    }
    @PostMapping("")
    public void addTodo(@RequestBody ToDo todo){
        toDoService.addToDo(todo);
    }

    @DeleteMapping("")
    public void deleteTodo(@RequestParam Long id){
        toDoService.deleteTodo(id);
    }


}
