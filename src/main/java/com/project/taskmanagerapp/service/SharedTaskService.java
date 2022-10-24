package com.project.taskmanagerapp.service;

import com.project.taskmanagerapp.model.SharedTask;
import com.project.taskmanagerapp.model.SharedTaskRequest;
import com.project.taskmanagerapp.model.Task;
import com.project.taskmanagerapp.model.User;
import com.project.taskmanagerapp.repository.SharedTaskRepository;
import com.project.taskmanagerapp.repository.TaskRepository;
import com.project.taskmanagerapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SharedTaskService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final SharedTaskRepository sharedTaskRepository;

    public SharedTaskService(UserRepository userRepository, TaskRepository taskRepository, SharedTaskRepository sharedTaskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.sharedTaskRepository = sharedTaskRepository;
    }

    public void shareTask(SharedTaskRequest sharedTaskRequest) {
        User existingUser = userRepository.findById(sharedTaskRequest.getUserId())
                .orElseThrow(NoSuchElementException::new);
        Task existingTask = taskRepository.findById(sharedTaskRequest.getTaskId())
                .orElseThrow(NoSuchElementException::new);
        SharedTask sharedTask = new SharedTask();
        sharedTask.setTask(existingTask);
        sharedTask.setUser(existingUser);
        sharedTaskRepository.save(sharedTask);
    }
}
