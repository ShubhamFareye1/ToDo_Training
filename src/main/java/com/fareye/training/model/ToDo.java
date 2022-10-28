package com.fareye.training.model;

import com.fareye.training.annotations.TitleValidation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Getter @Setter @NoArgsConstructor @ToString @TitleValidation @Entity
public class ToDo {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Integer userId;
    @NotNull
    private LocalDate dueDate;
    private LocalDate createdAt;

    private Date modifiedAt;

    @NotEmpty(message = "body : body should not be null")
    private String body;

    @NotEmpty(message = "title: title should not be null" )
    private String title;

    @NotEmpty(message = "status: status should be not empty")
    private String status;

    @Email(message = "userMail: Entered wrong email")
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
