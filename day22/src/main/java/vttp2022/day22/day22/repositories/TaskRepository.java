package vttp2022.day22.day22.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2022.day22.day22.model.Task;

import static vttp2022.day22.day22.repositories.Queries.*;

@Repository
public class TaskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer createTask(Task task) throws Exception {

        return jdbcTemplate.update(SQL_INSERT_TASK, 
                task.getTaskName(), task.getPriority().toString(), task.getAssignTo().getUsername(), task.getCompletionDate());
        
    }
    
}
