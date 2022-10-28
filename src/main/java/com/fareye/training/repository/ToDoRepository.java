package com.fareye.training.repository;
import com.fareye.training.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo,Long>{
    List<ToDo> findByUserId(Integer user_id);
}
