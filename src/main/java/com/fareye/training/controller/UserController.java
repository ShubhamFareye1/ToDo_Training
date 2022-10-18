package com.fareye.training.controller;

import com.fareye.training.exception.UserAlredyExistsException;
import com.fareye.training.exception.UserNotFoundException;
import com.fareye.training.model.User;
import com.fareye.training.service.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    Data data;

    @GetMapping("/user-list")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<User> userList(){
        return data.users;
    }

    @GetMapping("/userName")
    @CrossOrigin(origins = "http://localhost:3000")
    public User user(@RequestParam String userMail) throws UserNotFoundException {
        for(int i=0;i<data.users.size();i++){
            if(data.users.get(i).getEmail().equals(userMail)){
                return data.users.get(i);
            }
        }
        throw new UserNotFoundException("No user exist for this email");
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:3000")
    public String add(@Valid @RequestBody User name) throws UserAlredyExistsException {
         name.setId(Data.id);
         Data.id=Data.id+1;
        for(int i=0;i<data.users.size();i++){
            if(data.users.get(i).getEmail().equals(name.getEmail())){
                throw new UserAlredyExistsException("User already exist for this data");
            }
        }
        data.users.add(name);
        System.out.println(data.users);
        return "Data inserted successfully";
    }

    @DeleteMapping("/delete")
    @CrossOrigin(origins = "http://localhost:3000")
    public String delete(@RequestParam String email) throws RuntimeException {

        String u = "User Not Available";
        for(int i=0;i<data.users.size();i++){
            if(data.users.get(i).getEmail().equals(email)){
                u="User deleted Successfully";
                data.users.remove(i);
                return u;
            }
        }
        throw new UserNotFoundException("User Not Found this email");
    }

    @PutMapping("/update")
    @CrossOrigin(origins = "http://localhost:3000")
    public String update(@RequestBody User user1) throws UserNotFoundException {
        String u = "User Not Available";
        System.out.println("hello");
        for(int i=0;i<data.users.size();i++){
            System.out.println(data.users.get(i).getId()+" - "+user1.getId() +" - " + user1.getFirstName());
            if(data.users.get(i).getId()==user1.getId()){
                 u="Update successful";
                 data.users.set(i,user1);
                 return u;
            }
        }
        throw new UserNotFoundException("User Not Found Exception");
    }

}