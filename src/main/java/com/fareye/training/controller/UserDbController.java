package com.fareye.training.controller;

import com.fareye.training.model.User;
import com.fareye.training.service.Data;
import com.fareye.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserDbController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<User> userList(){
        return userService.getAllUsers();
    }

    @GetMapping("")
    public User user(@RequestParam Long userId){
        return userService.getUser(userId);
    }

    @PostMapping("")
    public void add(@Valid @RequestBody User user){
         userService.addUser(user);
    }

    @DeleteMapping("")
    public void delete(@RequestParam long id){
        userService.deleteUser(id);
    }

    @PutMapping("")
    public void update(@RequestBody User user){
        userService.updateUser(user);
    }

}
