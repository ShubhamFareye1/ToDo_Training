package com.fareye.training.controller;

import com.fareye.training.model.ToDo;
import com.fareye.training.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class UserControllerTest {



    @Test
    void userList() {
        User user = new User();
        user.setFirstName("shubham");
        user.setLastName("patidar");
        user.setEmail("shubham.patidar1@getfareye.com");
        user.setGithubUsername("shubhamFareye1");
        user.setPassword("Shubham1234");
        RestTemplate rs=new RestTemplate();
        User[] response = rs.getForObject("http://localhost:8080/user/list", User[].class);
//        assertEquals(response[0].getEmail(),user.getEmail());
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
        User response = rs.getForObject("http://localhost:8080/user?userMail="+mail, User.class);
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
                "http://localhost:8080/user",  user, String.class);
        String u1=response.getBody();
        assertEquals("Data inserted successfully",u1);
    }


    ;

    @Test
    void delete() {
        String result="User deleted Successfully";
        RestTemplate rs=new RestTemplate();
        String email = "shubham.patidar1@getfareye.com";
        String uri = "http://localhost:8080/user?email="+email;
        rs.delete(uri);
    }

    @Test
    void update() {
        User user = new User();
        user.setId(3);
        user.setFirstName("shubham");
        user.setLastName("pati");
        user.setEmail("shubham.patidar1@getfareye.com");
        user.setGithubUsername("shubhamFareye1");
        user.setPassword("Shubham1234");
        RestTemplate rs = new RestTemplate();
        rs.put("http://localhost:8080/user",user);
    }

    @Test
    void addNumber(){
        UserController user = new UserController();
        assertEquals(4,user.addNumber(2,2));
    }


}