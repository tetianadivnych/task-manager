package com.project.taskmanagerapp.contoller;

import com.project.taskmanagerapp.model.Task;
import com.project.taskmanagerapp.model.TaskRequest;
import com.project.taskmanagerapp.model.TaskWithSubtaskRequest;
import com.project.taskmanagerapp.model.TaskWithSubtasksResponse;
import com.project.taskmanagerapp.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

//    @GetMapping("/tasks")
//    public List<TaskResponse> getTasks() {
//        return taskService.getTasks();
//    }


    @PutMapping ("/subtasks")
    public void addSubtask(@RequestBody TaskWithSubtaskRequest taskWithSubtaskRequest) {
        taskService.addSubtask(taskWithSubtaskRequest);
    }

    @GetMapping("/subtasks")
    public List<TaskWithSubtasksResponse> getTasksWithSubtasks() {
        return taskService.getTasksWithSubtasks();
    }

    @PostMapping("/tasks")
    public void addTasks(@RequestBody TaskRequest taskRequest) {
        taskService.addTasks(taskRequest);
    }

    @PutMapping("/tasks")
    public void editTask(@RequestBody Task inputData) {
        taskService.editTask(inputData);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }


}
