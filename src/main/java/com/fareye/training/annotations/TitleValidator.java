package com.fareye.training.annotations;

import com.fareye.training.controller.ToDoController;
import com.fareye.training.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;


public class TitleValidator implements ConstraintValidator<TitleValidation , ToDo> {

     @Autowired
     ToDoController todo;

    @Override
    public boolean isValid(ToDo toDo, ConstraintValidatorContext constraintValidatorContext) {
        for(int i=0;i<todo.toDoList.size();i++){
            System.out.println( toDo.getTitle().equals(todo.toDoList.get(i).getTitle()) && toDo.getUserMail().equals(todo.toDoList.get(i).getUserMail()));
            if(toDo.getTitle().equals(todo.toDoList.get(i).getTitle()) && toDo.getUserMail().equals(todo.toDoList.get(i).getUserMail())){
                System.out.println("user alredy exxist");
                return false;
            }
        }
        return true;
    }
}
