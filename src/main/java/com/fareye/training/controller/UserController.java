package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    List<User> users = new ArrayList<>();
    @GetMapping("/user-list")
    public List<User> userList(){
        return users;
    }

    @GetMapping("/userName")
    public User user(@RequestParam String userMail) throws Exception {
        for(int i=0;i<users.size();i++){
            if(users.get(i).getEmail().equals(userMail)){
                return users.get(i);
            }
        }
        throw new Exception("User Not Found");
    }

    @PostMapping("/add")
    public List<User> add(@Valid @RequestBody User name) throws Exception {
        for(int i=0;i<users.size();i++){
            if(users.get(i).getEmail().equals(name.getEmail())){
                throw new Exception("User already exist");
            }
        }
        users.add(name);
        System.out.println(users);
        return users;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String email) throws Exception {

        String u = "User Not Available";
        for(int i=0;i<users.size();i++){
            if(users.get(i).getEmail().equals(email)){
                u="User deleted Successfully";
                users.remove(i);
                return u;
            }
        }
        throw new Exception("User not found");
    }

    @PutMapping("/update")
    public String update(@RequestBody User user1) throws Exception {
        String u = "User Not Available";
        for(int i=0;i<users.size();i++){
            if(users.get(i).getEmail().equals(user1.getEmail())){
                u="Update sucessful";
                users.set(i,user1);
                return u;
            }
        }
        throw new Exception("User Not Found Exception");
    }

}