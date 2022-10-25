package com.project.taskmanagerapp.service;

import com.project.taskmanagerapp.exception.CustomEntityNotFoundException;
import com.project.taskmanagerapp.model.*;
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
                .map(task -> convertTask(task))
                .collect(Collectors.toList());
    }

    private TaskResponse convertTask(Task task) {
        TaskResponse response = new TaskResponse();
        response.setTaskName(task.getTaskName());
        response.setTaskOwner(convertUser(task.getTaskOwner()));
        response.setTaskParticipants(getListOfUsers(task.getSharedTasks()));
        return response;
    }

    private UserResponse convertUser(User user) {
        UserResponse response = new UserResponse();
        response.setUserId(user.getId());
        response.setUserEmail(user.getEmail());
        return response;
    }

    private List<UserResponse> getListOfUsers(List<SharedTask> sharedTasks) {
        return sharedTasks.stream()
                .map(sharedTask -> sharedTask.getUser())
                .map(user -> convertUser(user))
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
