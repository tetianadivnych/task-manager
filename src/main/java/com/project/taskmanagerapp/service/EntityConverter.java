package com.project.taskmanagerapp.service;

import com.project.taskmanagerapp.model.Task;
import com.project.taskmanagerapp.model.TaskResponse;
import com.project.taskmanagerapp.model.User;
import com.project.taskmanagerapp.model.UserResponse;

import java.util.List;
import java.util.stream.Collectors;

public class EntityConverter {

    protected static TaskResponse convertTask(Task task) {
        TaskResponse response = new TaskResponse();
        response.setName(task.getTaskName());
        response.setOwner(convertUser(task.getTaskOwner()));
        response.setParticipants(convertParticipants(task));
        return response;
    }

    protected static UserResponse convertUser(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        return response;
    }

    private static List<UserResponse> convertParticipants(Task task) {
        return task.getSharedTasks().stream()
                .map(sharedTask -> sharedTask.getUser())
                .map(user -> EntityConverter.convertUser(user))
                .collect(Collectors.toList());
    }
}
