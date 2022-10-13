package com.project.taskmanagerapp.contoller;

import com.project.taskmanagerapp.model.Task;
import com.project.taskmanagerapp.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/tasks")
    public void addTasks(@RequestBody Task task) {
        taskService.addTasks(task);
    }
}
