package com.project.taskmanagerapp.service;

import com.project.taskmanagerapp.model.Task;
import com.project.taskmanagerapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public void addTasks(Task task) {
        taskRepository.save(task);
    }
}
