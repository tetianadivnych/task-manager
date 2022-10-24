package com.project.taskmanagerapp.service;

import com.project.taskmanagerapp.model.SharedTask;
import com.project.taskmanagerapp.model.SharedTaskRequest;
import com.project.taskmanagerapp.model.Task;
import com.project.taskmanagerapp.model.User;
import com.project.taskmanagerapp.repository.SharedTaskRepository;
import org.springframework.stereotype.Service;

@Service
public class SharedTaskService {

    private final UserService userService;
    private final TaskService taskService;
    private final SharedTaskRepository sharedTaskRepository;

    public SharedTaskService(UserService userService, TaskService taskService, SharedTaskRepository sharedTaskRepository) {
        this.userService = userService;
        this.taskService = taskService;
        this.sharedTaskRepository = sharedTaskRepository;
    }


    public void shareTask(SharedTaskRequest sharedTaskRequest) {
        User existingUser = userService.getUserById(sharedTaskRequest.getUserId());
        Task existingTask = taskService.getTaskById(sharedTaskRequest.getTaskId());
        SharedTask sharedTask = new SharedTask();
        sharedTask.setTask(existingTask);
        sharedTask.setUser(existingUser);
        sharedTaskRepository.save(sharedTask);
    }
}
