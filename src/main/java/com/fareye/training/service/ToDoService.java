package com.fareye.training.service;

import com.fareye.training.model.ToDo;
import com.fareye.training.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    public List<ToDo> toDoList(){
        return toDoRepository.findAll();
    }

    public List<ToDo> getTodos(Integer user_id){
        return toDoRepository.findByUserId(user_id);
    }

    public void addToDo(ToDo todo){
        toDoRepository.save(todo);
    }

    public  void deleteTodo(Long id){
        toDoRepository.deleteById(Long.valueOf(id));
    }

//    public void updateTodo(ToDo todo){
//
//    }
}
