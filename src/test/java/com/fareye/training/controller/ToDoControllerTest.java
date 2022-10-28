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
    void getToDOs() {
        ToDo todo = new ToDo();
        todo.setTitle("diwali dhamaka");
        todo.setBody("diwali gift by Fareye");
        todo.setUserMail("shubham.patidar1@getfareye.com");
        todo.setDueDate(LocalDate.parse("2022-10-30"));
        RestTemplate rs = new RestTemplate();
        ToDo[] todo1 = rs.getForObject("http://localhost:8080/todo/list",ToDo[].class);
        assertEquals(todo1[0].getUserMail(),todo.getUserMail());

    }

    @Test
    void getTodo() throws ParseException {
        ToDo todo = new ToDo();
        todo.setTitle("diwali dhamaka");
        todo.setBody("diwali gift by Fareye");
        todo.setUserMail("shubham.patidar1@getfareye.com");
        todo.setDueDate(LocalDate.parse("2022-10-30"));
        RestTemplate rs = new RestTemplate();
        String email = "shubham.patidar1@getfareye.com";
        ToDo[] todoObj = rs.getForObject("http://localhost:8080/todo?gmail="+email,ToDo[].class);
        System.out.println(todoObj.toString());
         assertEquals(todoObj[0].getUserMail(),todo.getUserMail());
    }

    @Test
    void postToDo() {
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
    void deleteTodo() {
        ToDo todo = new ToDo();
        todo.setTitle("diwali dhamaka");
        todo.setBody("diwali gift by Fareye");
        todo.setUserMail("shubham.patidar1@getfareye.com");
        todo.setDueDate(LocalDate.parse("2022-10-30"));
        todo.setStatus("Not Completed Yet Complete it soon");
        RestTemplate rs = new RestTemplate();
        rs.delete("http://localhost:8080/todo",todo);
    }

    @Test
    void updateTodo() {
        ToDo todo = new ToDo();
        todo.setTitle("diwali dhamaka");
        todo.setBody("diwali gift by Fareye");
        todo.setUserMail("shubham.patidar1@getfareye.com");
        todo.setDueDate(LocalDate.parse("2022-10-30"));
        todo.setStatus("Not Completed Yet Complete it soon");
        RestTemplate rs = new RestTemplate();
        rs.put("http://localhost:8080/todo",todo);

        //assertEquals(result[0].getUserMail(),todo.getUserMail());
    }
}