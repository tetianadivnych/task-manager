package com.project.taskmanagerapp.service;

import com.project.taskmanagerapp.exception.CustomEntityNotFoundException;
import com.project.taskmanagerapp.model.*;
import com.project.taskmanagerapp.repository.SubtaskRepository;
import com.project.taskmanagerapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final SubtaskRepository subtaskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, SubtaskRepository subtaskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.subtaskRepository = subtaskRepository;
        this.userService = userService;
    }

    public List<TaskResponse> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(task -> EntityConverter.convertTask(task))
                .collect(Collectors.toList());
    }

//    public List<TaskWithSubtasksResponse> getTasksWithSubtasks() {
//        List<Subtask> existingSubtasks = subtaskRepository.findAll();
//        List<Task> existingTasks = taskRepository.findAll();
//        return existingTasks.stream()
//                .map(task -> EntityConverter.convertTaskWithSubtask(task))
//                .collect(Collectors.toList());
//    }

    public List<TaskWithSubtasksResponse> getTasksWithSubtasks() {
        List<Task> existingTasks = taskRepository.findAll(); //
        return existingTasks.stream()
                .map(task -> EntityConverter.convertTaskWithSubtask(task))
                .collect(Collectors.toList());
    }



    public void addTasks(TaskRequest taskRequest) {
        User registeredUser = userService.getUserByEmail(taskRequest.getUserEmail());
        Task task = new Task();
        task.setTaskOwner(registeredUser);
        task.setTaskName(taskRequest.getTaskName());
        task.setDescription(taskRequest.getTaskDescription());
        taskRepository.save(task);
    }

    public void addSubtask(TaskWithSubtaskRequest taskWithSubtaskRequest) {
        Task existingTask = getTaskById(taskWithSubtaskRequest.getTaskId());
        Subtask existingSubtask = getSubtaskById(taskWithSubtaskRequest.getSubtaskId());
        existingSubtask.setTask(existingTask);
        taskRepository.save(existingTask);
        subtaskRepository.save(existingSubtask);
    }

    public void editTask(Task inputData) {
        Task task = getTaskById(inputData.getId());
        task.setTaskName(inputData.getTaskName());
        task.setDescription(inputData.getDescription());
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

    public Subtask getSubtaskById(Long subtaskId) {
        return subtaskRepository.findById(subtaskId)
                .orElseThrow(() -> new CustomEntityNotFoundException("Subtask with id: " + subtaskId + "  not found"));
    }

}
