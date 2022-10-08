package com.fareye.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Getter @Setter @NoArgsConstructor
public class ToDo {

    private LocalDate dueDate;

    private LocalDate createdAt;

    private Date modifiedAt;

    private String body;

    @NotNull(message = "title should not be null")
    @Min(value = 4 , message = "title should be more then 4 char..")
    private String title;
    @Min(value = 5 ,message = "status should be more then 5 char")
    private String status;

    private User user;

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
