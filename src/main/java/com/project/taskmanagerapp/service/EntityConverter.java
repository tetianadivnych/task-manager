package com.project.taskmanagerapp.service;

import com.project.taskmanagerapp.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class EntityConverter {

    protected static TaskResponse convertTask(Task task) {
        TaskResponse response = new TaskResponse();
        response.setName(task.getTaskName());
        response.setOwner(convertUser(task.getTaskOwner()));
        response.setParticipants(convertParticipants(task));
        response.setPriority(task.getTaskPriority());
        return response;
    }

    protected static TaskWithSubtasksResponse convertTaskWithSubtask(Task task) {
        TaskWithSubtasksResponse response = new TaskWithSubtasksResponse();
        response.setTaskId(task.getId());
        response.setTaskName(task.getTaskName());
        response.setSubtasks(convertSubtasks(task.getSubtasks()));
        return response;
    }



    private static SubtaskResponse convertSubtask(Subtask subtask) {
        SubtaskResponse response = new SubtaskResponse();
        response.setSubtaskName(subtask.getSubtaskName());
        response.setSubTaskId(subtask.getId());
        response.setPriority(subtask.getPriority());
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

    private static List<SubtaskResponse> convertSubtasks(List<Subtask> subtasks) {
        return subtasks.stream()
                .map(subtask -> convertSubtask(subtask))
                .collect(Collectors.toList());
    }


}
