package com.fareye.training.annotations;

import com.fareye.training.controller.ToDoController;
import com.fareye.training.model.ToDo;
import com.fareye.training.service.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;


public class TitleValidator implements ConstraintValidator<TitleValidation , ToDo> {

    @Autowired
    Data data;

    @Override
    public boolean isValid(ToDo toDo, ConstraintValidatorContext constraintValidatorContext) {
        for(int i=0;i<data.toDoList.size();i++){
            System.out.println( toDo.getTitle().equals(data.toDoList.get(i).getTitle()) && toDo.getUserMail().equals(data.toDoList.get(i).getUserMail()));
            if(toDo.getTitle().equals(data.toDoList.get(i).getTitle()) && toDo.getUserMail().equals(data.toDoList.get(i).getUserMail())){
                System.out.println("user already exists");
                return false;
            }
        }
        return true;
    }
}
