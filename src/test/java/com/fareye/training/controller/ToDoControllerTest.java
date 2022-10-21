package com.fareye.training.controller;

import com.fareye.training.model.ToDo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ToDoControllerTest {

  //  private Object ;

    @Test
    void todoList() {
        ToDo todo = new ToDo();
        todo.setTitle("diwali dhamaka");
        todo.setBody("diwali gift by Fareye");
        todo.setUserMail("shubham.patidar1@getfareye.com");
        todo.setDueDate(LocalDate.parse("2022-10-30"));
        RestTemplate rs = new RestTemplate();
        ToDo[] todo1 = rs.getForObject("http://localhost:8080/todo",ToDo[].class);
        assertEquals(todo1[0].getUserMail(),todo.getUserMail());

    }

    @Test
    void todo1() throws ParseException {
        ToDo todo = new ToDo();
        todo.setTitle("diwali dhamaka");
        todo.setBody("diwali gift by Fareye");
        todo.setUserMail("shubham.patidar1@getfareye.com");
        todo.setDueDate(LocalDate.parse("2022-10-30"));
        RestTemplate rs = new RestTemplate();
        String email = "shubham.patidar1@getfareye.com";
        ToDo[] todoObj = rs.getForObject("http://localhost:8080/todo1?gmail="+email,ToDo[].class);
        System.out.println(todoObj.toString());
//        JSONParser parser = new JSONParser();
        // Gson
        // Jackson
//        JSONObject json1 = (JSONObject) parser.parse(json);
//         JSONParser parser = new JSONParser();
//         Object obj  = parser.parse(json);
         assertEquals(todoObj[0].getUserMail(),todo.getUserMail());
    }

    @Test
    void todo() {
        ToDo todo = new ToDo();
        todo.setTitle("diwali dhamaka");
        todo.setBody("diwali gift by Fareye");
        todo.setUserMail("shubham.patidar1@getfareye.com");
        todo.setDueDate(LocalDate.parse("2022-10-30"));
        todo.setStatus("Not Completed Yet Complete it soon");
        RestTemplate rs = new RestTemplate();
        ToDo result[] = rs.postForObject("http://localhost:8080/todo",todo,ToDo[].class);
        assertEquals(result[0].getUserMail(),todo.getUserMail());

    }

    @Test
    void delete() {
        ToDo todo = new ToDo();
        todo.setTitle("diwali dhamaka");
        todo.setUserMail("shubham.patidar1@getfareye.com");
        RestTemplate rs = new RestTemplate();
       // rs.delete("http://localhost:8080/delete",todo);
       // rs.delete("http://localhost:8080/delete",todo);

    }

    @Test
    void update() {
        ToDo todo = new ToDo();
        todo.setTitle("diwali dhamaka");
        todo.setBody("diwali gift by Fareye");
        todo.setUserMail("shubham.patidar1@getfareye.com");
        todo.setDueDate(LocalDate.parse("2022-10-30"));
        todo.setStatus("Not Completed Yet Complete it soon");
        RestTemplate rs = new RestTemplate();
        rs.put("http://localhost:8080/update",todo);

        //assertEquals(result[0].getUserMail(),todo.getUserMail());
    }
}