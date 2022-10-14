package com.project.taskmanagerapp.service;

import com.project.taskmanagerapp.model.Task;
import com.project.taskmanagerapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void editTask(Task inputData) {
        Optional<Task> taskId = taskRepository.findById(inputData.getId());
        Task task = taskId.get();
        task.setTaskName(inputData.getTaskName());
        task.setDescription(inputData.getDescription());
        task.setPriority(inputData.getPriority());
        task.setTaskOwner(inputData.getTaskOwner());
        taskRepository.save(task);
    }

}
