package vttp2022.day22.day22.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.day22.day22.model.Task;
import vttp2022.day22.day22.model.User;
import vttp2022.day22.day22.repositories.TaskRepository;
import vttp2022.day22.day22.service.UserService;

@Controller
@RequestMapping(path="/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired 
    private UserService usrSvc;

    @GetMapping
    public String showTask(){
        return "task";
    }

  
    @PostMapping
    public String postTask(@RequestBody MultiValueMap<String, String> form, Model model) throws Exception{

        User user = new User();
        user.setUsername(form.getFirst("username"));
        user.setPassword(form.getFirst("password"));

        if (!usrSvc.validateUser(user)) {
            return "fail_validation";
        }

        Task task = new Task();
        task.setTaskName(form.getFirst("taskName"));
        task.setPriority(form.getFirst("priority"));
        task.setAssignTo(user);
        task.setCompletionDate(form.getFirst("completion"));

        Integer count = taskRepo.createTask(task);


    


        System.out.printf(">>>>> %s, count: %d\n", task.toString(), count);


        return "created-task";
        
    }


    
}
