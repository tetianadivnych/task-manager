package com.project.taskmanagerapp.service;

import com.project.taskmanagerapp.model.Task;
import com.project.taskmanagerapp.model.TaskRequest;
import com.project.taskmanagerapp.model.User;
import com.project.taskmanagerapp.repository.TaskRepository;
import com.project.taskmanagerapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }


    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public void addTasks(TaskRequest taskRequest) {
        User registeredUser = userRepository.findByEmail(taskRequest.getUserEmail()).orElseThrow(NoSuchElementException::new);
        Task task = new Task();
        task.setTaskOwner(registeredUser);
        task.setTaskName(taskRequest.getTaskName());
        task.setPriority(taskRequest.getTaskPriority());
        task.setDescription(taskRequest.getTaskDescription());
        taskRepository.save(task);
    }

    public void editTask(Task inputData) {
        Task task = taskRepository.findById(inputData.getId()).orElseThrow(NoSuchElementException::new);
        task.setTaskName(inputData.getTaskName());
        task.setDescription(inputData.getDescription());
        task.setPriority(inputData.getPriority());
        task.setTaskOwner(inputData.getTaskOwner());
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow(NoSuchElementException::new);
    }
}
