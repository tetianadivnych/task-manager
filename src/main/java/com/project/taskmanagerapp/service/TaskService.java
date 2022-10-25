package com.project.taskmanagerapp.service;

import com.project.taskmanagerapp.exception.CustomEntityNotFoundException;
import com.project.taskmanagerapp.model.Task;
import com.project.taskmanagerapp.model.TaskRequest;
import com.project.taskmanagerapp.model.TaskResponse;
import com.project.taskmanagerapp.model.User;
import com.project.taskmanagerapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public List<TaskResponse> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(task -> EntityConverter.convertTask(task))
                .collect(Collectors.toList());
    }

    public void addTasks(TaskRequest taskRequest) {
        User registeredUser = userService.getUserByEmail(taskRequest.getUserEmail());
        Task task = new Task();
        task.setTaskOwner(registeredUser);
        task.setTaskName(taskRequest.getTaskName());
        task.setPriority(taskRequest.getTaskPriority());
        task.setDescription(taskRequest.getTaskDescription());
        taskRepository.save(task);
    }

    public void editTask(Task inputData) {
        Task task = getTaskById(inputData.getId());
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
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new CustomEntityNotFoundException("Task with id: " + taskId + "  not found"));
    }

}
