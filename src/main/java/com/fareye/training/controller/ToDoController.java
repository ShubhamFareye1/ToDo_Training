package com.fareye.training.controller;
import com.fareye.training.model.ToDo;
import com.fareye.training.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoController {

    public List<ToDo> toDoList = new ArrayList<>();
    @Autowired
    UserController user;

    @GetMapping("/todo")
    public List<ToDo> todo() throws  NullPointerException{
        return toDoList;
    }

    @GetMapping("/todo1")
    public List<ToDo> todo1(@RequestParam String gmail) throws Exception {
        List<ToDo> list = new ArrayList<>();
        for(int i=0;i<toDoList.size();i++){
            if(gmail.equals(toDoList.get(i).getUserMail())){
                list.add(toDoList.get(i));
            }
        }
        if(list.size()==0)
            throw new Exception("User Not Found");
        return list;
    }

    @PostMapping("/todo")
    public ResponseEntity<List<ToDo>> todo(@Valid @RequestBody ToDo toDo) throws Exception {
        boolean userFlag=false;
        for(int i=0;i<user.users.size();i++){
            if(user.users.get(i).getEmail().equals(toDo.getUserMail()))
            {
                userFlag=true;
                break;
            }
        }
        if(userFlag) {
            toDoList.add(toDo);
            return new ResponseEntity<>(toDoList, HttpStatus.OK);
        }
        throw new Exception("User not exist for this mail first add user then add users");
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody ToDo todo) throws Exception {

        String u = "User Not Available";
        for(int i=0;i<toDoList.size();i++){
            if(toDoList.get(i).getUserMail().equals(todo.getUserMail()) && toDoList.get(i).getTitle().equals(todo.getTitle())){
                toDoList.remove(i);
                u = "User data deleted successfully";
                return u;
            }
        }
        throw new Exception("Data not found");
    }

    @PutMapping("/update")
    public String update(@RequestBody ToDo todo) throws Exception {
        String u;
        for(int i=0;i<toDoList.size();i++){
            if(toDoList.get(i).getUserMail().equals(todo.getUserMail()) && toDoList.get(i).getTitle().equals(todo.getTitle())){
                toDoList.add(todo);
                u = "User data deleted successfully";
                return u;
            }
        }
        throw new Exception("UserName not register for this email");
    }

}