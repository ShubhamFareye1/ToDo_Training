package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    List<User> users = new ArrayList<>();
    @GetMapping("/user-list")
    public List<User> hello(){
        return users;
    }

    @PostMapping("/add")
    public List<User> add(@RequestBody User name){
        users.add(name);
        System.out.println(users);
        return users;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String email){

        String u = "User Not Available";
        for(int i=0;i<users.size();i++){
            if(users.get(i).getEmail().equals(email)){
                u=users.get(i).getFirstName();
                users.remove(i);
            }
        }
        return u;
    }

    @PutMapping("/update")
    public String update(@RequestBody User user1){
        String u = "User Not Available";
        for(int i=0;i<users.size();i++){
            if(users.get(i).getEmail().equals(user1.getEmail())){
                u="Update sucessful";
                users.set(i,user1);
            }
        }
        return u;
    }

}