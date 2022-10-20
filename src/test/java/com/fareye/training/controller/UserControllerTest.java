package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class UserControllerTest {


    @BeforeEach
    public void createUser(){
      // delete();
    }

    @AfterEach
    public void deleteUser(){
      // add();
    }

    @Test
    void userList() {
        User user = new User();
        user.setFirstName("shubham");
        user.setLastName("patidar");
        user.setEmail("shubham.patidar1@getfareye.com");
        user.setGithubUsername("shubhamFareye1");
        user.setPassword("Shubham1234");
        RestTemplate rs=new RestTemplate();
        User[] response = rs.getForObject("http://localhost:8080/user/user-list", User[].class);
//        List<User> u1 = new ArrayList<>();
//        u1= (List<User>) response.getBody();
         //assertEquals(response[0].getEmail(),user.getEmail());
    }

    @Test
    void user() {
        User user = new User();
        user.setFirstName("shubham");
        user.setLastName("patidar");
        user.setEmail("shubham.patidar1@getfareye.com");
        user.setGithubUsername("shubhamFareye1");
        user.setPassword("Shubham1234");
        String mail= "shubham.patidar1@getfareye.com";
        RestTemplate rs=new RestTemplate();
        User response = rs.getForObject("http://localhost:8080/user/userName?userMail="+mail, User.class);
        assertEquals(response.getEmail(),user.getEmail());
    }

    @Test
    void add() {
        User user = new User();
        user.setFirstName("shubham");
        user.setLastName("patidar");
        user.setEmail("shubham.patidar1@getfareye.com");
        user.setGithubUsername("shubhamFareye1");
        user.setPassword("Shubham1234");
        UserController user1 = new UserController();
        RestTemplate rs=new RestTemplate();
        ResponseEntity<String>response = rs.postForEntity(
                "http://localhost:8080/user/add",  user, String.class);
        String u1=response.getBody();
        assertEquals("Data inserted successfully",u1);

    }


    ;

    @Test
    void delete() {
        String result="User deleted Successfully";
        RestTemplate rs=new RestTemplate();
        String email = "shubham.patidar1@getfareye.com";
        String uri = "http://localhost:8080/user/delete?email="+email;
        rs.delete(uri);
//        System.out.println(result1);
//        assertEquals(result,result1);
    }

    @Test
    void update() {
    }

    @Test
    void addNumber(){
        UserController user = new UserController();
        assertEquals(4,user.addNumber(2,2));
    }


}