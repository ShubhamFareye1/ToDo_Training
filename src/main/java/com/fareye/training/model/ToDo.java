package com.fareye.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Getter @Setter @NoArgsConstructor
public class ToDo {
    @NotNull
    private LocalDate dueDate;
    private LocalDate createdAt;

    private Date modifiedAt;

    @NotEmpty(message = "body should not be null")
    private String body;

    @NotEmpty(message = "title should not be null" )
    private String title;

    @NotEmpty(message = "Title should be not empty")
    private String status;

    @Email(message = "Entered wrong email")
    private String userMail;

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        LocalDateTime now = LocalDateTime.now();
        this.dueDate = dueDate;
    }


    public void setCreatedAt(LocalDate createdAt) {
        LocalDate now = LocalDate.now();
        this.createdAt = now;
    }

}
