package com.project.taskmanagerapp.service;

import com.project.taskmanagerapp.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class EntityConverter {

    protected static TaskResponse convertTask(Task task) {
        TaskResponse response = new TaskResponse();
        response.setName(task.getTaskName());
        response.setOwner(convertUser(task.getTaskOwner()));
        response.setParticipants(getListOfUsers(task.getSharedTasks()));
        return response;
    }

    protected static UserResponse convertUser(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        return response;
    }

    protected static List<UserResponse> getListOfUsers(List<SharedTask> sharedTasks) {
        return sharedTasks.stream()
                .map(sharedTask -> sharedTask.getUser())
                .map(user -> EntityConverter.convertUser(user))
                .collect(Collectors.toList());
    }
}
