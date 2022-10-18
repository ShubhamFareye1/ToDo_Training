package com.fareye.training.controller;
import com.fareye.training.exception.UserNotFoundException;
import com.fareye.training.model.ToDo;
import com.fareye.training.service.Data;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {

    @Autowired
    Data data;
    @Autowired
    UserController user;


    @GetMapping("/todo")
    public List<ToDo> todoList() throws  NullPointerException{
        return data.toDoList;
    }

    @GetMapping("/todo1")
    public List<ToDo> todo1(@RequestParam String gmail) throws UserNotFoundException {
        List<ToDo> list = new ArrayList<>();
        for(int i=0;i<data.toDoList.size();i++){
            if(gmail.equals(data.toDoList.get(i).getUserMail())){
                list.add(data.toDoList.get(i));
            }
        }
        if(list.size()==0)
            throw new UserNotFoundException("Data Not exist for this user");
        return list;
    }

    @PostMapping("/todo")
    public ResponseEntity<List<ToDo>> todo(@Valid @RequestBody ToDo toDo) throws UserNotFoundException {
        boolean userFlag=false;
        for(int i=0;i<data.users.size();i++){
            if(data.users.get(i).getEmail().equals(toDo.getUserMail()))
            {
                userFlag=true;
                break;
            }
        }
        if(userFlag) {
            data.toDoList.add(toDo);
            return new ResponseEntity<>(data.toDoList, HttpStatus.OK);
        }
        throw new UserNotFoundException("User not exist for this mail first add user");
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody ToDo todo) throws RuntimeException {
        String u = "User Not Available";
        for(int i=0;i<data.toDoList.size();i++){
            if(data.toDoList.get(i).getUserMail().equals(todo.getUserMail()) && data.toDoList.get(i).getTitle().equals(todo.getTitle())){
                data.toDoList.remove(i);
                u = "User data deleted successfully";
                return u;
            }
        }
        throw new RuntimeException("Data not found!!!");
    }

    @PutMapping("/update")
    public String update(@RequestBody ToDo todo) throws UserNotFoundException {
        String u;
        for(int i=0;i<data.toDoList.size();i++){
            if(data.toDoList.get(i).getUserMail().equals(todo.getUserMail()) && data.toDoList.get(i).getTitle().equals(todo.getTitle())){
                data.toDoList.set(i,todo);
                u = "User data updated successfully";
                return u;
            }
        }
        throw new UserNotFoundException("UserName not register for this email");
    }
}